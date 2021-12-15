package com.tutorial.java.functionalinterfaceexample;

@FunctionalInterface
public interface GreetingMessage {

    public abstract void greet(String name);
}
