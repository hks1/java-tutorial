package com.tutorial.java.interfaces;

public class MySubInterfaceImpl implements MySubInterface{
    @Override
    public void sayItAll() {
        System.out.println("MySubInterfaceImpl sayItAll()");
    }

    @Override
    public void sayHello() {
        System.out.println("MySubInterfaceImpl sayHello()");
    }
}
