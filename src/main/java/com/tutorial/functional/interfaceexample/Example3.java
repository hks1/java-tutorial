package com.tutorial.functionalinterfaceexample;

import java.util.function.BiFunction;

public class Example3 {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> add = (x,y) -> x+y;
        System.out.println(add.apply(32, 64));

        com.tutorial.functionalinterfaceexample.TriFunction<Integer, Integer, Integer, Integer> addThree = (x, y, z) -> x + y + z;
        System.out.println(addThree.apply(54, 55, 56));

        com.tutorial.functionalinterfaceexample.NoArgFunction<String> sayHello = () -> "Hello!";
        System.out.println(sayHello.apply());
    }
}
