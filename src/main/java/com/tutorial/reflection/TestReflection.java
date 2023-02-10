package com.tutorial.reflection;

import java.lang.reflect.Modifier;
import java.util.Arrays;

public class TestReflection {
    public static void main(String[] args) {
        // Get class using reflection
        Class<?> concreteClass = ConcreteClass.class;
        concreteClass = new ConcreteClass(5).getClass();

        try{
            // below method is used most of the times in frameworks like JUnit,
            // Spring dependency injection, Tomcat web container,
            // Eclipse auto completion of method names, hibernate, Struts2 etc.
            // because ConcreteClass is not available at compile time
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


        try{
            Class<?> superClass = Class.forName("com.tutorial.reflection.ConcreteClass").getSuperclass();
            System.out.println(superClass); // prints "class com.tutorial.reflection.BaseClass"
            System.out.println(Object.class.getSuperclass()); // prints "null"
            System.out.println(String[][].class.getSuperclass()); // prints "class java.lang.Object"
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        Class<?>[] classes = concreteClass.getClasses();
        /*
        [interface com.tutorial.reflection.ConcreteClass$ConcreteClassPublicInterface,
        class com.tutorial.reflection.ConcreteClass$ConcreteClassPublicEnum,
        class com.tutorial.reflection.ConcreteClass$ConcreteClassPublicClass,
        class com.tutorial.reflection.BaseClass$BaseClassMemberEnum,
        class com.tutorial.reflection.BaseClass$BaseClassInnerClass]
         */
        System.out.println(Arrays.toString(classes));

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

        try{
            Class<?> innerClass = Class.forName("com.tutorial.reflection.ConcreteClass$ConcreteClassDefaultClass");
            System.out.println(innerClass.getDeclaringClass()); //class com.tutorial.reflection.ConcreteClass
            System.out.println(innerClass.getEnclosingClass()); // class com.tutorial.reflection.ConcreteClass
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        try{
            System.out.println(Class.forName("com.tutorial.reflection.BaseInterface").getPackage().getName());

            System.out.println(Modifier.toString(concreteClass.getModifiers())); // public
            System.out.println(Modifier.toString(Class.forName("com.tutorial.reflection.BaseInterface").getModifiers())); // public abstract interface
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }


    }
}
