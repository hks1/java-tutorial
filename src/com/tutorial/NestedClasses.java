package com.tutorial;

public class NestedClasses {
    public NestedClasses(){
        System.out.println("NestedClasses::");
    }
    public static class Nested{
        public Nested(){
            System.out.println("Nested::");
        }

    }

    public static void main(String[] args) {
        Example example = new Example();
        example.testNested();
    }
}

class Example{
    public Example(){
        System.out.println("Example::");
    }
    public void testNested(){
        //NestedClasses.Nested instance = new NestedClasses.Nested();
        NestedClasses nestedClasses = new NestedClasses();
    }
}
