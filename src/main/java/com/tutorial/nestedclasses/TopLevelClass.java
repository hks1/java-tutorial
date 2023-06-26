package com.tutorial.nestedclasses;

public class TopLevelClass {
    void accessMembers(OuterClass outer){
        // Compiler Error: cannot make a static reference to the non-static fieldOuterClass.outerField
        // System.out.println(OuterClass.outerField);

        System.out.println(outer.outerField);
        System.out.println(OuterClass.staticOuterField);
    }
}
