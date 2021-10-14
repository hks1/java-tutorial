package com.tutorial.java.lambda;

// Static Method References

interface Finder{
    public int find(String s1, String s2);
}

class MyClass {
    public static int doFind(String s1, String s2){
        return s1.lastIndexOf(s2);
    }
}

public class MethodReferencesEx1 {
    public static void main(String[] args) {
        Finder finder = MyClass::doFind;

        int index = finder.find("water", "ate");
        System.out.println(index);
    }
}
