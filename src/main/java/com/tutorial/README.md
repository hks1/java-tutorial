// tutorial

# [lambda](https://github.com/hks1/java-tutorial/blob/main/src/main/java/com/tutorial/lambda/README.md)

# [Future](https://github.com/hks1/java-tutorial/blob/main/src/main/java/com/tutorial/future/Future.md)

https://github.com/hks1/java-tutorial/blob/main/src/main/java/com/tutorial/functional/functional.md

https://github.com/hks1/java-tutorial/blob/main/src/main/java/com/tutorial/functional/supplier/supplier.md


# Local Classes
- defined in a _block_, which is a group of zero or more statements between balanced braces.

**Example** </br>
com.tutorial.localclasses.LocalClassExample

**Accessing Members of an Enclosing Class** </br>
- A local class has access to the **members** of its enclosing class 

In addition, a local class has access to local variables (variables of the enclosing block - block which local class is part of). 
However, a local class can only access local variables that are declared _final_.

When a local class accesses a local variable or parameter of the enclosing block, it _captures_ that variable or parameter.

However, starting Java SE 8, a local class can access local variables and parameters of the enclosing block that are final or _effectively_ final.
A variable or parameter whose value is never changed after it is initialized is effectively final.
```java
int numberLength = 10; // is ok as long as it is not modified
```
 
Starting JAVA SE 8, if a local class is declared in a method, it can access the method's parameters.
```java
method {
        ...
class PhoneNumber{
    ...
    // valid in JDK 8 and later
    public void printOriginalNumbers(){
        System.out.println("Original numbers are: " + phoneNumber1 + " and " + phoneNumber2);
    }
    ...
}
...
// valid in JDK 8 and later
        myNumber1.printOriginalNumbers();
                ...
        }
```

**Shadowing and Local Classes** </br>

Declaration of a type (such as a variable) in a local class shadow declarations in the enclosing scope that have the same name.



<!-- # Shadowing -->
<!-- https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html#shadowing -->
Example:
com.tutorial.shadowing.ShadowTest

# Nested Classes
<!-- https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html -->
**Terminology:** Nested classes are divided into two categories:
- non-static - called _inner classes_
- static - called _static nested classes_

```java
class OuterClass{
    ...
    class InnerClass{
        ...
    }
    static class StaticNestedClass{
        ...
    }
}
```

- A nested class is a member of it's enclosing class, even if they are declared private.
- Non-static nested classes (inner classes) have access to other members of the enclosing class.
- As a member of the `OuterClass`, a nested class can be declared `private`, `public`, `protected`, or `package private`.
- outer classes can only be declared as `public` or package private

**Why Use Nested Classes?**
- It is a way of logically grouping classes that are only used in one place.
- It increases encapsulation.
- It can read to more readable and maintainable code.

## Inner Classes
**an inner class**
- is associated with an instance of its enclosing class.
- has direct access to that object's methods and fields.
- cannot define any static members itself. (because it's associated with an instance)

Objects that are instances of an inner class exist _within_ an instance of the outer class

```java
class OuterClass {
    ...
    class InnerClass {
        ...
    }
}
```
**To instantiate an inner class:**
- first instantiate the outer class
- then, create the inner object within the outer object with following syntax:

```java
OuterClass onterObject = new OuterClass();
OuterClass.InnerClass innerObject = outerObject.new InnerClass();
```

There are two special kinds of inner classes:
- **local classes**
- **anonymous classes**

## Static Nested Classes
a static nested class
- is associated with its outer class.
- cannot refer directly to instance variables or methods defined in it's enclosing class. (It can use them only through an object reference)

> **Note:** A static nested class interacts with the instance members of its outer class (and other classes) just like any other top-level class.
> In effect, a static nested class is behaviorally a top-level class that has been nested in another top-level class for package convenience.

you instantiate a static nested class the same way as a top-level class. </br>
StaticNestedClass staticNestedObject = new StaticNestedClass();

## Example
| com.tutorial.nestedclasses |
| --- |
| OuterClass |
| TopLevelClass |
| InnerClass |
| StaticNestedClass |

## Shadowing
If a declaration of a type (such as a member variable or a parameter name) in a particular scope (such as an inner class or a method definition) has the same name as another declaration in the enclosing scope, 
then the declaration _shadows_ the declaration of the enclosing scope.
> A shadowed declaration cannot be referred to by its name alone.

```java
package com.tutorial.shadowing;

public class ShadowTest {
    public int x = 0;

    class FirstLevel{
        public int x = 1;

        void methodInFirstLevel(int x){
            System.out.println("x: " + x);
            System.out.println("this.x: " + this.x);
            System.out.println("ShadowTest.this.x: " + ShadowTest.this.x);
        }
    }

    public static void main(String[] args) {
        ShadowTest st = new ShadowTest();
        ShadowTest.FirstLevel f1 = st.new FirstLevel();
        f1.methodInFirstLevel(23);
    }
}
```

output>>
`
x: 23
this.x: 1
ShadowTest.this.x: 0
`

## serialization
<!-- https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html -->
Serialization of inner classes, including local and anonymous classes, is strongly discouraged. When the Java compiler compiles certain constructs, such as inner classes, it creates synthetic constructs; these are classes, methods, fields, and other constructs that do not have a corresponding construct in the source code. Synthetic constructs enable Java compilers to implement new Java language features without changes to the JVM. However, synthetic constructs can vary among different Java compiler implementations, which means that .class files can vary among different implementations as well. Consequently, you may have compatibility issues if you serialize an inner class and then deserialize it with a different JRE implementation. See the section Implicit and Synthetic Parameters in the section Obtaining Names of Method Parameters for more information about the synthetic constructs generated when an inner class is compiled.

# Anonymous Classes
<!-- https://docs.oracle.com/javase/tutorial/java/javaOO/anonymousclasses.html -->

- declare and instantiate a class at the same time
- like local classes except that they do not have a name
- local classes are class declarations, anonymous classes are expressions, meaning that anonymous classes are defined in another expression.

## Example
com.tutorial.anonymous.HelloWorldAnonymousClasses

## Syntax
The syntax of an anonymous class expression is like the invoking of a constructor, 
except that there is a class definition contained in a block of code.

```java
HelloWorld frenchGreeting = new HelloWorld(){
    String name = "tout le monde";
    public void greet(){
        greetSomeone("tout le monde");
        }
    public void greetSomeone(String someone){
        name = someone;
        System.out.println("Salut " + name);
        }
}
```

The anonymous class expression consists of the following:
- The `new` operator
- The name of an interface to implement or class to extend.
- Parentheses that contain the arguments to a constructor, just like a normal class instance creation expression. **Note:** When you implement an interface, there is no constructor, so you use an empty pair of parentheses, as in above example.
- A body, which is a class declaration body. More specifically, in the body, method declarations are allowed but statements are not.

Anonymous class definition is an expression, it must be part of a statement.
<!-- In this example, the anonymous class expression is part of the statement that instantiates the frenchGreeting object. 
(This explains why there is a semicolon after the closing brace.) -->

## Accessing local variables of the enclosing scope, and declaring and accessing members of the Anonymous class
| **TODO** |
| --- |
| https://docs.oracle.com/javase/tutorial/java/javaOO/localclasses.html#accessing-members-of-an-enclosing-class |
| https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html#shadowing |
| https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html |

> If an interface contains only one method, lambda expression can be used instead of an anonymous class expression

- Anonymous classes are ideal for implementing an interface that contains two or more methods.
 

# Immutable objects in Java
<!-- https://www.baeldung.com/java-immutable-object#benefits-of-immutability -->

- An immutable object is an **object whose internal state remains constant after it has been entirely created**

```java
@Test
    void testImmutableObjects() {
        String name = "Power One";
        String newName = name.replace("One", "----");

        assertEquals("Power One", name); // pass - name doesn't change
        assertEquals("Power ----", newName); // newName is a new instance
    }
```

## The _final_ keyword
- In Java, **variables are mutable by default, meaning we can change the value they hole**

- By using the _final_ keyword when declaring a variable, 
- the Java compiler wouldn't let us change the value of that variable. 
```java
final String name = "Immutable";
        name = "mutable"; // cannot assign value to final variable 'name'
```

**Note:** _final_ only forbids us from changing the reference the variable holds, 
it doesn't protect us from changing the internal state of the object it refers to by using its public API.
```java
@Test
    void testImmutableObjectReference(){
        final List<String> strings = new ArrayList<>();
        assertEquals(0, strings.size());
        strings.add("ImmutableTest");
        assertEquals(0, strings.size());  // fails - "ImmutableTest" is added to the 'strings' list and size is now 1
    }
```

## Immutability in Java
Building the API of an immutable object requires us to guarantee that its internal state won't change no matter how we use its API.

A step forward in the right direction is to use final when declaring its attributes:
```java
class Money {
    private final double amount;
    private final Currency currency;

    // ...
}
```

Note that Java guarantees us that the value of amount won't change, 
that's the case with all primitive type variables.

However, in our example we are only guaranteed that the currency won't change, 
so **we must rely on the Currency API to protect itself from changes.**

```java
class Money{
    // ...
    public Money(double amount, Currency currency){
        this.amount = amount;
        this.currency = currency;
    }
    public Currency getCurrency(){
        return currency;
    }
    public double getAmount(){
        return amount;
    }
    
    // No set method to ensure the immutability
}
```

**Note:** to meet the requirements of an immutable API, Money class only has read-only methods.

Using the reflection API, we can break immutability and change immutable objects. 
However, reflection violates immutable object's public API, and usually, we should avoid doing this.

## Benefits
- Since the internal state of an immutable object remains constant in time, **we can share it safely among multiple threads**
- **immutable objects are side-effects free.**

<!-- https://github.com/eugenp/tutorials/tree/master/core-java-modules/core-java-lang-oop-patterns -->