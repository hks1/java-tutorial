package com.tutorial.patterns.abstractfactory;

public class WinFactory implements GUIFactory{

    public WinFactory(){
        System.out.println("created WinFactory instance!!!");
    }
    @Override
    public Button createButton() {
        return new WinButton();
    }

    @Override
    public CheckBox createCheckbox() {
        return new WinCheckbox();
    }

    @Override
    public String toString() {
        return "new WinFactory instance";
    }
}
