package com.tutorial.java.annotations;

public class ClassWithDeprecatedMethod {

    @Deprecated
    public void doIt() {
        System.out.println("Do it method");
    }
}
