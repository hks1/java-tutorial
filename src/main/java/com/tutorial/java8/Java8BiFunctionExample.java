package com.tutorial.java8;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Java8BiFunctionExample {
    public static void main(String[] args) {

        // a basic apply example
        BiFunction<Integer, Integer, Integer> f1 = (a, b) -> a + b;
        System.out.println(f1.apply(10, 20)); // 30

        // a basic andThen example
        Function<Integer, Integer> f2 = a -> a * a;
        System.out.println(f1.andThen(f2).apply(2,3));

        // above line f1.andThen(f2).apply(2,3) is equivalent to following code
        Integer j1 = f1.apply(2,3);
        Integer j2 = f2.apply(j1);

        System.out.println(j2);
    }
}
