package com.tutorial;

class MyClass {
    public MyClass(){
        System.out.println("MyClass::");
    }
    class MyNestedClass{
        MyNestedClass(){
            System.out.println("MyNestedClass::");
        }

    }
}

public class Example7 extends MyClass{
    // Nested class and inheritance
    public Example7(){
        System.out.println("Example7::");
    }

    public static void main(String[] args) {
        Example7 example7 = new Example7();
        MyNestedClass myNestedClass = example7.new MyNestedClass();
        System.out.println("");
    }
}
