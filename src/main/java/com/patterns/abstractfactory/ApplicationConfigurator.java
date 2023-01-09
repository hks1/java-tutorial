package com.patterns.abstractfactory;

public class ApplicationConfigurator {
    private static final String os = "Windows";
    public static void main(String[] args) {
        GUIFactory guiFactory;
        if(os == "Windows"){
            guiFactory = new WinFactory();
        }else {
            guiFactory = new MacFactory();
        }
        Application app = new Application(guiFactory);

        app.createUI();
        app.paint();

    }
}
