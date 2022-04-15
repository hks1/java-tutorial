package com.tutorial.functional.interfaceexample;

import java.util.function.Function;

public class Example2 {
    public static void main(String[] args) {
        Function<Integer, Integer> absoluteValue =
                (x) -> x > 0 ? x : -x;

        System.out.println(absoluteValue.apply(-5));
    }


}
