package com.tutorial.anonymous;

public class AnonymousClassExample1 {
    public interface HelloWorld{
        public void sayHello();
        public void greet(String name);
    }

    String classVariable = "test Class Variable";
    final String finalClassVariable = "test final class variable";

    public void testLocalVariable(){
        HelloWorld englishGreeting = new HelloWorld() {
            String name = "May MarryWeather";
            @Override
            public void sayHello() {
                System.out.println("Hello!");
                System.out.println("printing final variable from enclosing scope: " + finalClassVariable);
                System.out.println("printing non-final variable from enclosing scope: " + classVariable);
                classVariable = "modified non-final variable";
                System.out.println("printing non-final variable from enclosing scope: " + classVariable);
            }

            @Override
            public void greet(String name) {
                name = name;
                System.out.println("Hello " + name);
            }
        };
        englishGreeting.greet("Fred");
        englishGreeting.sayHello();
    }

    public static void main(String[] args) {
        AnonymousClassExample1 obj = new AnonymousClassExample1();
        obj.testLocalVariable();
        System.out.println(obj.classVariable);
        System.out.println(obj.finalClassVariable);
    }
}
