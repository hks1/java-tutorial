package com.tutorial.patterns.abstractfactory;

public class MacFactory implements GUIFactory{

    public MacFactory(){
        System.out.println("MacFactory instance!!!");
    }
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public CheckBox createCheckbox() {
        return new MacCheckbox();
    }

    @Override
    public String toString() {
        return "new MacFactory instance";
    }
}
