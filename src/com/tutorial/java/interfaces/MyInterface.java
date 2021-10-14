package com.tutorial.java.interfaces;

public interface MyInterface {

    public String hello = "Hello";
    // Java interface can contain constants
    // All variables in an interface are implicitly public, static and final
    int FALSE = 0;
    int TRUE = 1;

    public void sayHello();

    // Interface static methods
    public static void print(String text){
        System.out.println(text);
    }

    public static void main(String[] args) {
        System.out.println(MyInterface.hello);
    }
}
