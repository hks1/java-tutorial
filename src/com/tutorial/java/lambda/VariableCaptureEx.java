package com.tutorial.java.lambda;

public class VariableCaptureEx {

    static String thirdText = "Third text...";

    private String fourthText = "Fourth Text";

    public void doIt(){
        final String otherText = "Hello: ";

        MyInterface myInterface = (text -> {
            System.out.println(otherText + text + " " + fourthText);
        });

        myInterface.printIt("ABCD");
        fourthText = "Blahblah";
        myInterface.printIt("ABCD");
    }

    public static void main(String[] args) {
        String otherText = "Hello: ";
        MyInterface myInterface = text -> {
            System.out.println(otherText + text + thirdText);
        };

        // member variables can be changed and still be accessed from within lambda expressions.

        myInterface.printIt("ABC");
        thirdText = "Changed third text";

        myInterface.printIt("ABC");

        //otherText = "Final"; //compiler will show error if this line is commented
        // this is because
        // variable used in lambda expression should be final or effectively final. - only for local variables

        System.out.println("Variable Cature:::::::::::::::::::");
        VariableCaptureEx variableCaptureEx = new VariableCaptureEx();
        variableCaptureEx.doIt();
    }
}
