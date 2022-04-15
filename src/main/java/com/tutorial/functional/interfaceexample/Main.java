package com.tutorial.functional.interfaceexample;

import java.util.Random;
import java.util.function.IntBinaryOperator;

public class Main {

    public static void main(String[] args) {
        GreetingMessage gm = new GreetingMessage() {
            @Override
            public void greet(String name) {
                System.out.println("Hello " + name);
            }
        };

        gm.greet("Jues!");

        // lambdas
        GreetingMessage gm2 = (String name) -> {
            System.out.println("Hello " + name);
        };

        gm2.greet("Jues!");

        MessagePrinter mp = () -> {
            System.out.println("This is a message");
        };

        mp.printMessage();

        Calculator calculator = (x,y) -> x + y;
        int z = calculator.calculate(5, 3);
        System.out.println(z);
        Calculator calculator1 = (x, y) -> {
            Random random = new Random();
            int randomNumber = random.nextInt(50);
            return x * y + randomNumber;
        };
        System.out.println(calculator1.calculate(1,2));

        IntBinaryOperator calculator2 = (x, y) -> {
            Random random = new Random();
            int randomNumber = random.nextInt(80);
            return x * y + randomNumber;
        };
        System.out.println(calculator2.applyAsInt(2,3));
    }
}
