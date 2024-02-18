package com.tutorial.solid.ocp.ex2;

// https://softwareengineering.stackexchange.com/questions/178488/lsp-vs-ocp-liskov-substitution-vs-open-close/178515#178515
// Context is close for modification.
// Meaning you are not supposed to change the code here
public class Context {

    // Context is however open for extension through
    // this private field
    private IBehavior behavior;

    // The context calls the behavior in this public
    // method. If you want to change this, you need to
    // implement it in  IBehavior object
    public void doStuff(){
        if(this.behavior != null){
            this.behavior.doStuff();
        }
    }

    // you can dynamically set a new behavior at will

    public void setBehavior(IBehavior behavior) {
        this.behavior = behavior;
    }
}

