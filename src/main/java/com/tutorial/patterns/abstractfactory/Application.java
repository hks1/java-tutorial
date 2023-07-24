package com.tutorial.patterns.abstractfactory;

public class Application {
    GUIFactory factory;
    Button button;

    public Application(GUIFactory factory){
        this.factory = factory;
        this.button = factory.createButton();
        System.out.println("Application initiated with " + factory);
    }
    public void createUI(){
        System.out.println(this.getClass().getName() + " : " + new Object() {}.getClass().getEnclosingMethod().getName());
        System.out.println(factory);
        //this.button = factory.createButton();
    }
    public void paint(){
        button.paint();
    }

    @Override
    public String toString() {
        return "Application{" +
                "factory=" + factory +
                ", button=" + button +
                '}';
    }
}
