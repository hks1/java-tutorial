package com.tutorial.solid.lsp;

// outcome 1
public class HelloVisitor implements IVisitor{
    @Override
    public boolean canDo(String query) {
        return query.equals("Hello");
    }

    @Override
    public void doStuff() {
        System.out.println("Hello World!");
    }
}
