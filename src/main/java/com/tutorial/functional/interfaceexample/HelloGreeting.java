package com.tutorial.functional.interfaceexample;

public class HelloGreeting implements GreetingMessage{

    public void greet(String hello){
        System.out.println("hello world!"+ hello);
    }
}

class TDHelloClass{
    public static void main(String[] args) {
        GreetingMessage greeting = new HelloGreeting();
        greeting.greet("Hello!!!");

        // no need of HelloGreeting class
        GreetingMessage greetingMessage = new HelloGreeting(){
            @Override
            public void greet(String str){
                System.out.println(str);
            }
        };
        greetingMessage.greet("Hello Again!");

        //  using lambda
        GreetingMessage greetingMessage1 = (str) -> System.out.println(str);
        greetingMessage1.greet("hello lambda!!!");
    }
}


