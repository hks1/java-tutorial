package com.tutorial.lambda;

public class LambdaExample1 {
    public static void main(String[] args) {
        MyFunction myFunction = () -> {
            System.out.println("Hello World");
        };

        myFunction.apply();

        MyFunctionWithParameter myFunctionWithParameter = text -> System.out.println(text);

        myFunctionWithParameter.printText("Hello Function!!!");
    }
}
