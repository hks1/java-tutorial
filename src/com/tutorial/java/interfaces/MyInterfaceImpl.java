package com.tutorial.java.interfaces;

public class MyInterfaceImpl implements MyInterface{
    @Override
    public void sayHello() {
        System.out.println(MyInterface.hello);
    }

    public static void main(String[] args) {
        MyInterface myInterface = new MyInterfaceImpl();
        myInterface.sayHello();

        // calling interface static method using interface name
        MyInterface.print("interface static method");
    }
}
