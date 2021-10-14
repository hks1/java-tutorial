package com.tutorial;

public class Outer {
    private String text = "outer private text!";
    public Outer(){
        System.out.println("Outer::");
    }
    public class Inner{
        private String text = "inner private text";
        public Inner(){
            System.out.println("Inner::");
        }
        public void printText(){
            System.out.println("referencing inner class 'text' field: " + text);
            System.out.println("referencing Outer class 'text' field: " + Outer.this.text);
        }
    }
    public void printText(){
        System.out.println(text);
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        Ex1 ex1 = new Ex1();
        ex1.testMethod();
        //outer.printText();
        // Anonymous classes
        // An anonymous class can access members of the enclosing class.
            // It can also access local variables which are declared final or effectively final (since Java 8).
        //
        //You can declare fields and methods inside an anonymous class,
            // but you cannot declare a constructor.
            // You can declare a static initializer for the anonymous class instead, though.
        Ex1 ex11 = new Ex1() {
            private String aText = "anonymous class text";
            public void testMethod(){
                System.out.println("test anonymous class");
                System.out.println(this.aText);
            }

        };
        ex11.testMethod();

    }
}

class Ex1{
    public Ex1(){
        System.out.println("Ex1::");
    }
    public void testMethod(){
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.printText();
        outer.printText();
    }
}
