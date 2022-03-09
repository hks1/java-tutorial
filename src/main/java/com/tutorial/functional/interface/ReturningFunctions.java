package com.tutorial.functionalinterfaceexample;

import java.util.function.Function;

public class ReturningFunctions {
    protected static class MyMath{
        public static Integer timeTwo(Integer x){
            return x * 2;
        }
        public static Integer timesThree(Integer x){
            return x * 3;
        }
        public static Integer timesFour(Integer x){
            return x * 4;
        }
        public static Function<Integer, Integer> createMultiplier(Integer y){
            return (Integer x) -> x * y;
        }
    }

    public static void main(String[] args) {
        com.tutorial.functionalinterfaceexample.NoArgFunction<com.tutorial.functionalinterfaceexample.NoArgFunction<String>> createGreeter = () -> {
            return () -> "Hello functional!";
        };
        com.tutorial.functionalinterfaceexample.NoArgFunction<String> greeter = createGreeter.apply();

        com.tutorial.functionalinterfaceexample.NoArgFunction<com.tutorial.functionalinterfaceexample.NoArgFunction<String>> sayHello = () -> () -> "Hello!!";
        com.tutorial.functionalinterfaceexample.NoArgFunction<String> hello = sayHello.apply();

        System.out.println(greeter.apply());
        System.out.println(hello.apply());

        Function<Integer, Integer> timesTwo = MyMath.createMultiplier(2);
        Function<Integer, Integer> timesThree = MyMath.createMultiplier(3);
        Function<Integer, Integer> timesFour = MyMath.createMultiplier(4);

        System.out.println(timesTwo.apply(6));
        System.out.println(timesThree.apply(6));
        System.out.println(timesFour.apply(6));
    }
}
