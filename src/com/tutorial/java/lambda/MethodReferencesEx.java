package com.tutorial.java.lambda;

interface MyPrinter{
    public void print(String s);
}

public class MethodReferencesEx {
    public static void main(String[] args) {
        MyPrinter myPrinter = s -> System.out.println(s);

        // When all lambda expression does is
        // to call another method with the parameters passed to the lambda,
        // the Java lambda implementation provides a shorter way to express the method call.

        // Here is how a lambda method reference looks
        MyPrinter myPrinter1 = System.out::println;     // method reference
        // Notice the ::. These signal to the Java compiler that this is a method reference.
        // The method referenced is what comes after the double colons.
        // Whatever class or object that owns the referenced method comes before the double colons.
    }
}
