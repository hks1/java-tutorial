package com.tutorial.java8;

import java.util.Arrays;
import java.util.List;

public class Java8BiFunction1 {
    public static void main(String[] args) {

        // take two Integers and return an Integer
        BiFunction<Integer, Integer, Integer> func = (x1, x2) -> x1 + x2;

        Integer result = func.apply(2,3);

        // take two integers and return a Double
        BiFunction<Integer, Integer, Double> func2 = (x1, x2) -> Math.pow(x1, x2);

        Double result2 = func2.apply(2,4);

        // take two Integers and return a List<Integer>
        BiFunction<Integer, Integer, List<Integer>> func3 = (x1,x2) -> Arrays.asList(x1 + x2, x1 -x2);

        List<Integer> result3 = func3.apply(2,3);

        System.out.println(result3);
    }
}
