package com.tutorial.solid.lsp;

public interface IVisitor {
    public boolean canDo(String query);
    public void doStuff();
}
