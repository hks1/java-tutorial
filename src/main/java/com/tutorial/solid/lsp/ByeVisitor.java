package com.tutorial.solid.lsp;

// outcome 2
public class ByeVisitor implements IVisitor{
    @Override
    public boolean canDo(String query) {
        return query.equals("Bye");
    }

    @Override
    public void doStuff() {
        System.out.println("C ya!");
    }
}
