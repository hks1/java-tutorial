package com.tutorial.java.generics;

public class GenericFactory<T> {
    Class aClass = null;

    public GenericFactory(Class aClass){
        this.aClass = aClass;
    }

    public T createInstance()
        throws IllegalAccessException, InstantiationException {
        return (T) this.aClass.newInstance();
    }
}

class Main {
    public static void main(String[] args) {
        GenericFactory<MyClass> factory =
                new GenericFactory<>(MyClass.class);
        System.out.println(factory.getClass().getName());

        try{
            MyClass myClassInstance = factory.createInstance();
            System.out.println(myClassInstance);
            System.out.println(myClassInstance.getClass().getName());
        } catch (Exception e){
            e.printStackTrace();
        }

        GenericFactory<AnotherClass> factory1 =
                new GenericFactory<>(AnotherClass.class);
        System.out.println("\n" + factory1.getClass().getName());

        try {
            AnotherClass anotherClassInstance = factory1.createInstance();
            System.out.println(anotherClassInstance);
            System.out.println(anotherClassInstance.getClass().getName());
        } catch(Exception e){
            e.printStackTrace();
        }

    }
}

class MyClass{
    int data = 0;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "data=" + data +
                '}';
    }
}

class AnotherClass{
    String str = "name one here";

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return "AnotherClass{" +
                "str='" + str + '\'' +
                '}';
    }
}
