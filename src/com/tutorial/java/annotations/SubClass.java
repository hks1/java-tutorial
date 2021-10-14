package com.tutorial.java.annotations;

public class SubClass extends SuperClass{

    @Override
    public void print() {
        super.print();
        System.out.println("Print SubClass Message");
    }
    // Compiler will error out if method name overridden in this class is changed in SuperClass
}
