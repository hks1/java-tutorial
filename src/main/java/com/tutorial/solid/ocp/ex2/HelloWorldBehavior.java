package com.tutorial.solid.ocp.ex2;

public class HelloWorldBehavior implements IBehavior{
    @Override
    public void doStuff() {
        System.out.println("Hello World!");
    }
}
