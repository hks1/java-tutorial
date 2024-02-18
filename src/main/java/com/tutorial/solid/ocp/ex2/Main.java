package com.tutorial.solid.ocp.ex2;

public class Main {
    public static void main(String[] args) {
        Context c = new Context();

        c.setBehavior(new HelloWorldBehavior());
        c.doStuff();

        c.setBehavior(new GoodByeBehavior());
        c.doStuff();
    }
}
