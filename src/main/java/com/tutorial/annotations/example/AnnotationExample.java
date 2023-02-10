package com.tutorial.annotations.example;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class AnnotationExample {
    public static void main(String[] args) {

    }

    @Override
    @MethodInfo(author = "hks1", comments = "main method", date = "Feb 9, 2023")
    public String toString(){
        return "Overriden toString()";
    }
    @Deprecated
    @MethodInfo(comments = "deprecated method", date = "Feb 10, 2023")
    public static void oldMethod(){
        System.out.println("old method, don't use it.");
    }
    @SuppressWarnings({"unchecked", "deprecation"})
    @MethodInfo(author = "hks1", comments = "main method", date = "Feb 11, 2023", revision = 2)
    public static void genericTest() throws FileNotFoundException{
        List l = new ArrayList();
        l.add("abc");
        oldMethod();
    }
}
