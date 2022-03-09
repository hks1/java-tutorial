package com.tutorial.lambda;

// Parameter Method Reference

// Using following interface from MethodReferenceEx1
/*
interface Finder{
    public int find(String s1, String s2);
}

The interface is intended to represent a component able to search s1 foe occurrences of s2.
 */

// Here is an example of Java lambda expression that calls String.indexOf() to search:

public class MethodReferencesEx2 {
    public static void main(String[] args) {
        Finder finder = String::indexOf;
        // The Java compiler will attempt to match the referenced method against the first parameter type,
            // using the second parameter type as parameter to the referenced method.


        // This is equivalent of this lambda definition
        Finder finder1 = (s1, s2) -> s1.indexOf(s2);

        System.out.println(finder.find("Hello World!!", "World"));
        System.out.println(finder1.find("Hello World!", "World"));
    }
}
