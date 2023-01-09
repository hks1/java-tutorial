package com.patterns.abstractfactory;

public class MacCheckbox implements CheckBox{
    @Override
    public String toString() {
        return "MacCheckbox instance";
    }

    @Override
    public void paint() {
        System.out.println("MacCheckbox paint() method");
    }
}
