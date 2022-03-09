package com.tutorial.functionalinterfaceexample;

@FunctionalInterface
public interface GreetingMessage {

    public abstract void greet(String name);
}
