package com.tutorial.annotations;

public class ClassWithDeprecatedMethod {

    @Deprecated
    public void doIt() {
        System.out.println("Do it method");
    }
}
