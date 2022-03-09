package com.tutorial.lambda;

public class LambdaExample2 {
    public static void main(String[] args) {
        MyFunctionWithReturn myFunctionWithReturn = (text1, text2) -> {
            System.out.println(text1 + " + " + text2);
            return text1 + text2;
        };

        String returnValue = myFunctionWithReturn.concatStrings("Hello Function Body", "Test");
        System.out.println(returnValue);

        MyFunctionWithReturn myFunctionWithReturn1 = myFunctionWithReturn;
        String returnValue2 = myFunctionWithReturn1.concatStrings("TExt 1", "Exst 2");
        System.out.println(returnValue2);
    }
}
