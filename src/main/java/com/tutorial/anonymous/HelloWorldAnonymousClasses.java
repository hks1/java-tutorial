package com.tutorial.anonymous;

public class HelloWorldAnonymousClasses {
    // HelloWorld interface
    interface HelloWorld{
        public void greet();
        public void greetSomeone(String someone);
    }

    public void sayHello(){




        class EnglishGreeting implements HelloWorld{
            String name = "world";
            @Override
            public void greet() {
                greetSomeone("World");
            }

            @Override
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Hello " + name);
            }
        }

        // uses a local class for the initialization of the variable englishGreeting

        HelloWorld englishGreeting = new EnglishGreeting();

        // uses anonymous classes in the initialization statements of the local variables frenchGreeting and spanishGreeting

        HelloWorld frenchGreeting = new HelloWorld() {
            String name = "tout le monde";
            @Override
            public void greet() {
                greetSomeone("tour le monde");
            }

            @Override
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Salut " + name);
            }
        };

        HelloWorld spanishGreeting = new HelloWorld() {
            String name = "mundo";
            @Override
            public void greet() {
                greetSomeone("mundo");
            }

            @Override
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Hola, " + name);
            }
        };

        englishGreeting.greet();
        frenchGreeting.greetSomeone("Fred");
        spanishGreeting.greet();
    }

    public static void main(String[] args) {
        HelloWorldAnonymousClasses myApp = new HelloWorldAnonymousClasses();
        myApp.sayHello();
    }

}
