package com.tutorial.functional.interfaceexample;

public class Closure {
    public static void main(String[] args) {
        com.tutorial.functionalinterfaceexample.NoArgFunction<com.tutorial.functionalinterfaceexample.NoArgFunction<String>> creteGreeter = () -> {
            String name = "anyone";
            return () -> "Hello, " + name;
        };

        com.tutorial.functionalinterfaceexample.NoArgFunction<String> greeter = creteGreeter.apply();
        System.out.println(greeter.apply());
    }
}
