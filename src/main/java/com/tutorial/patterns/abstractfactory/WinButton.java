package com.tutorial.patterns.abstractfactory;

public class WinButton implements Button{
    @Override
    public void paint() {
        System.out.println("WinButton paint() method");
    }

    @Override
    public String toString() {
        return "WinButton instance";
    }
}
