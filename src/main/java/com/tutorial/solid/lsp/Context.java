package com.tutorial.solid.lsp;

import java.util.ArrayList;
import java.util.List;

// https://softwareengineering.stackexchange.com/questions/178488/lsp-vs-ocp-liskov-substitution-vs-open-close/178515#178515
public class Context {
    /*public void doStuff(String query){

        // outcome no. 1
        if(query.equals("Hello")){
            System.out.println("Hello World!");
        }

        // outcome no. 2
        if(query.equals("Bye")){
            System.out.println("C ya!");
        }

        // a change request may require another outcome...
    }*/



    /*
    Using Visitor pattern
     */

    private List<IVisitor>  visitors= new ArrayList<>();

    public Context(){
        visitors.add(new HelloVisitor());
        visitors.add(new ByeVisitor());
    }

    // instead of if-statements, go through all visitors
    // and use the canDo() method to determine if the
    // visitor object is the right one to "visit"
    public void doStuff(String query){
        for(IVisitor visitor : visitors){
            if (visitor.canDo(query)){
                visitor.doStuff();
                break;
                // or return ... it depends if you have logic
                // after this foreach loop
            }
        }
    }

    // dynamically adds new visitors
    public void addVisitor(IVisitor visitor){
        if(visitor != null){
            visitors.add(visitor);
        }
    }

    // Main
    public static void main(String[] args) {
        Context c = new Context();
        c.doStuff("Hello");
        c.doStuff("Bye");
    }
}
