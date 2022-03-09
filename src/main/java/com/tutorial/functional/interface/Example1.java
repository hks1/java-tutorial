package com.tutorial.functionalinterfaceexample;

import java.util.function.Function;

public class Example1 {
    protected static class MyMath{
        public static int triple(int x){
            return 3 * x;
        }
    }

    public static void main(String[] args) {
        Function<Integer, Integer> myTriple = MyMath::triple;
        int result = myTriple.apply(5);
        System.out.println(result);
    }
}
