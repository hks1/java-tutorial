package com.tutorial.functional.interfaceexample;

@FunctionalInterface
public interface GreetingMessage {

    public abstract void greet(String name);
}
