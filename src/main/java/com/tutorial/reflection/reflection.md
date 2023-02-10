# Java Reflection
<!-- https://www.digitalocean.com/community/tutorials/java-reflection-example-tutorial -->
- provides ability to inspect and modify the runtime behavior of the application.
- can inspect a class, [interface](#java-reflection), [enum](#java-reflection), get their structure, methods and fields information at runtime even though class is not accessbile at compile time.
- can be used to instantiate an object, invoke it's methods, change field values.

Some examples of frameworks that use java reflection:
1. __JUnit__ - Uses reflection to parse @Test annotation to get the test methods and then invoke them.
2. __Spring__ - dependency injection,  [Spring Dependency Injection](#java-reflection)
3. __Tomcat__ web container to forward the request to correct module by parsing their web.xml and request URI.
4. __Eclipse__ auto completion of method names
5. __Struts__
6. __Hibernate__

<!-- The list is endless and they all use java reflection because all these frameworks have no knowledge and access of user defined classes, interfaces, their methods etc. -->

We should not use reflection in normal programming where we already have access to the classes and interfaces because of following drawbacks.
- __Poor Performance__ 
- __Security Restrictions__
- __Security Issues__
- __High Maintenance__

## Java Reflection for Classes
object
- primitive type - boolean, byte, short, int, long, char, float, double
- reference - e.g., classes, enums, arrays, inherit from `java.lang.Object`

__java.lang.Class__ is the entry point for all reflection operations.

For every type of object, [JVM](#java-reflection) instantiate an [immutable](#java-reflection) instance of `java.lang.Class` that provides methods to examine the runtime properties of the object and create new objects, invoke it's method and get/set object fields.
[inheritence](#java-reflection)

Here are some classes and interfaces with inheritance hierarchy

```java
package com.tutorial.reflection;

public interface BaseInterface {
    public int interfaceInt=0;

    void method1();

    int method2(String str);
}

```

```java
package com.tutorial.reflection;

public class BaseClass {
    public int baseInt;

    private static void method3(){
        System.out.println("Method3");
    }
    public int method4(){
        System.out.println("Method4");
        return 0;
    }
    public static int method5(){
        System.out.println("Method5");
        return 0;
    }
    void method6(){
        System.out.println("Method6");
    }

    //Inner public class
    public class BaseClassInnerClass{}

    //member public enum
    public enum BaseClassMemberEnum{}
}

```

```java
package com.tutorial.reflection;

public class ConcreteClass extends BaseClass implements BaseInterface{
    public int publicInt;
    private String privateString="private string";
    protected boolean protectedBoolean;
    Object defaultObject;

    public ConcreteClass(int i){
        this.publicInt = i;
    }


    @Override
    public void method1() {
        System.out.println("Method1 impl.");
    }

    @Override
    public int method2(String str) {
        System.out.println("Method2 IMpl.");
        return 0;
    }
    @Override
    public int method4() {
        System.out.println("Method4 overridden.");
        return super.method4();
    }
    public int method5(int i){
        System.out.println("Method 5.");
        return 0;
    }
    // inner classes
    public class ConcreteClassPublicClass{}
    private class ConcreteClassPrivateClass{}
    protected class ConcreteClassProtectedClass{}
    class ConcreteClassDefaultClass{}

    //member enum
    enum ConcreteClassDefauleEnum{}
    public enum ConcreteClassPublicEnum{}

    // member interface
    public interface ConcreteClassPublicInterface{}

}

```

### Get Class Object
get Class of an object
- through static variable `class`
- using `getClass()` method of object
- `java.lang.Class.forName(String fullyClassifiedClassName)`

for primitive types and arrays
- use static variable `class`

Wrapper classes provide another static variable `TYPE` to get the class.

```java
package com.tutorial.reflection;

public class TestReflection {
    public static void main(String[] args) {
        // Get class using reflection
        Class<?> concreteClass = ConcreteClass.class;
        concreteClass = new ConcreteClass(5).getClass();

        try{
            concreteClass = Class.forName("com.tutorial.reflection.ConcreteClass");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        System.out.println(concreteClass.getCanonicalName());

        // for primitive classes, wrapper classes and arrays
        Class<?> booleanClass = boolean.class;
        System.out.println(booleanClass.getCanonicalName());

        Class<?> cDouble = Double.TYPE;
        System.out.println(cDouble.getCanonicalName());

        try{
            Class<?> cDoubleArray = Class.forName("[D");
            System.out.println(cDoubleArray.getCanonicalName());
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        Class<?> twoDStringArray = String[][].class;
        System.out.println(twoDStringArray.getCanonicalName());

    }
}

```

`getCanonicalName()` - returns the canonical name of the underlying class.

Notice that lava.lang.Class uses Generics, it helps frameworks in making sure that the Class retrieved is subclass of framework base class.

### Get Super Class
getSuperClass() method
- on a Class object, it returns the super class of the class
- if this Class represents either the Object class, an interface, a primitive type, or void, then null is returned.
- if the object represents an array class then the Class object representing the Object class is returned.

```java
try{
    Class<?> superClass = Class.forName("com.tutorial.reflection.ConcreteClass").getSuperclass();
    System.out.println(superClass); // prints "class com.tutorial.reflection.BaseClass"
    System.out.println(Object.class.getSuperclass()); // prints "null"
    System.out.println(String[][].class.getSuperclass()); // prints "class java.lang.Object"
}catch (ClassNotFoundException e){
    e.printStackTrace();
}
```

### Get Public Member Classes
getClasses() method of a Class representation of object returns an array containing Class objects representing all the 
- public classes
- interfaces
- enums
that are members of the class represented by this Class object.
This includes public class and interface members inherited from superclasses and public class and interface members declared by the class.
This method returns an array of length 0
- if this Class object has no public member classes or interfaces, or
- if this Class object represents a primitive type, an array class, or void.

```java
Class<?>[] classes = concreteClass.getClasses();
/*
[interface com.tutorial.reflection.ConcreteClass$ConcreteClassPublicInterface, 
class com.tutorial.reflection.ConcreteClass$ConcreteClassPublicEnum, 
class com.tutorial.reflection.ConcreteClass$ConcreteClassPublicClass, 
class com.tutorial.reflection.BaseClass$BaseClassMemberEnum, 
class com.tutorial.reflection.BaseClass$BaseClassInnerClass]
 */
System.out.println(Arrays.toString(classes));
```

### Get Declared Classes
getDeclaredClasses() method
- returns an array of Class objects reflecting all the classes and interfaces declared as members of the class represented by this Class object.
- the returned array doesn't include classes declared in inherited classes and interfaces.

```java
// getting all of the classes, interfaces and enums that are explicitly declared in ConcreteClass
/*Class<?>[] explicitClasses = concreteClass.getDeclaredClasses();
System.out.println(Arrays.toString(explicitClasses));
System.out.println(concreteClass);*/
try{
    Class<?>[] explicitClasses = Class.forName("com.tutorial.reflection.ConcreteClass").getDeclaredClasses();
    /*
    [interface com.tutorial.reflection.ConcreteClass$ConcreteClassPublicInterface, 
    class com.tutorial.reflection.ConcreteClass$ConcreteClassPublicEnum, 
    class com.tutorial.reflection.ConcreteClass$ConcreteClassDefauleEnum, 
    class com.tutorial.reflection.ConcreteClass$ConcreteClassDefaultClass, 
    class com.tutorial.reflection.ConcreteClass$ConcreteClassProtectedClass, 
    class com.tutorial.reflection.ConcreteClass$ConcreteClassPrivateClass, 
    class com.tutorial.reflection.ConcreteClass$ConcreteClassPublicClass]
     */
    System.out.println(Arrays.toString(explicitClasses));
}catch (ClassNotFoundException e){
    e.printStackTrace();
}

```

### Get Declaring Class
getDeclaringClass()
- returns the Class object representing the class in which it was declared.

```java
try{
    Class<?> innerClass = Class.forName("com.tutorial.reflection.ConcreteClass$ConcreteClassDefaultClass");
    System.out.println(innerClass.getDeclaringClass()); //class com.tutorial.reflection.ConcreteClass
    System.out.println(innerClass.getEnclosingClass()); // class com.tutorial.reflection.ConcreteClass
}catch (ClassNotFoundException e){
    e.printStackTrace();
}
```

### Getting Package Name
getPackage().getName()

```java
System.out.println(Class.forName("com.tutorial.reflection.BaseInterface").getPackage().getName());
// com.tutorial.reflection
```

### Getting Class Modifiers
getModifiers() - returns int representation of the class modifiers.
We can use java.lang.reflect.Modifier.toString() method to get it in the string format

```java
System.out.println(Modifier.toString(concreteClass.getModifiers())); // public
System.out.println(Modifier.toString(Class.forName("com.tutorial.reflection.BaseInterface").getModifiers())); // public abstract interface
```

### Get Type Parameters
getTypeParameters()

### Get Implemented Interfaces
getGenericInterfaces()
getInterfaces()

### Get All Public Methods
getMethods()

### Get All Public Constructors
getConstructors()

### Get All Public Fields
getFields()

### Get All Annotations
getAnnotations()

## Java Reflection for Fields

## Get Public Field
getField()

### Field Declaring Class
getDeclaringClass()

### Get Field Type
getType()

### Get/Set Public Field Value

### Get/Set Private Field Value

## Java Reflection for Methods

### Get Public Method
getMethod()

### Invoking Public Method
invoke()

### Invoking Private Method

## Java Reflection for Constructors

### Get Public Constructor

### Instantiate Object Using Constructor

## Reflection for Annotations




<!--
[interface](https://www.digitalocean.com/community/tutorials/interface-in-java) 
[enum](https://www.digitalocean.com/community/tutorials/java-enum)
[Spring Dependency Injection](https://www.digitalocean.com/community/tutorials/spring-dependency-injection)
[JVM](https://www.digitalocean.com/community/tutorials/difference-jdk-vs-jre-vs-jvm)
[immutable](https://www.digitalocean.com/community/tutorials/how-to-create-immutable-class-in-java)
[inheritence](https://www.digitalocean.com/community/tutorials/inheritance-java-example)
[Java Generics Tutorial](https://www.digitalocean.com/community/tutorials/java-generics-example-method-class-interface)
-->
