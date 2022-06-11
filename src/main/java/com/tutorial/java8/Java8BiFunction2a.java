package com.tutorial.java8;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Java8BiFunction2a {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Double> func1 = (a1, a2) -> Math.pow(a1, a2);

        // takes Double, returns String
        Function<Double, String> func2 = (input) -> "Result: " + String.valueOf(input);

        String result = func1.andThen(func2).apply(2,4);

        System.out.println(result);
    }
}
