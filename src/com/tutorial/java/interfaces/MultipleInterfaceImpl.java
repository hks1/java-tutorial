package com.tutorial.java.interfaces;

public class MultipleInterfaceImpl implements MyInterface, MyOtherInterface{
    @Override
    public void sayHello() {
        System.out.println("Hello!!!");
    }

    @Override
    public void sayGoodbye() {
        System.out.println("Goodbye!!!");
    }
}
