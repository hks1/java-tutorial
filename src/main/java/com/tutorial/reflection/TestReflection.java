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
