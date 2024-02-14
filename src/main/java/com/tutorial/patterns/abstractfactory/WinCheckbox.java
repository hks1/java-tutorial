package com.tutorial.patterns.abstractfactory;

public class WinCheckbox implements CheckBox{
    @Override
    public void paint() {
        System.out.println("WinCheckbox paint() method");
    }

    @Override
    public String toString() {
        return "WinCheckbox instance";
    }
}
