package com.tutorial.java.lambda;

import org.w3c.dom.ls.LSOutput;

import java.util.Comparator;

public class LambdaExample {
    public static void main(String[] args) {
        // implement comparison without Lambda
        Comparator<String> stringComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };

        int comparison = stringComparator.compare("Java", "Hello");
        System.out.println(comparison);

        // implement Comparator interface using Java Lambda expression
        Comparator<String> stringComparatorLambda =
                (String o1, String o2) -> { return o1.compareTo(o2);};

        System.out.println("// Implementing comparator using Lambda expression");
        int lambdaComparison = stringComparatorLambda.compare("Java", "Hello");
        System.out.println(lambdaComparison);

        Comparator<String> stringComparatorLambda1 =
                (o1, o2) -> o1.compareTo(o2); // shortened - no Type for parameters, no return keyword, no {}
        System.out.println(stringComparatorLambda1.compare("Java", "Hello"));



    }

}
