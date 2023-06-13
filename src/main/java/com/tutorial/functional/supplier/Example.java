package com.tutorial.functional.supplier;

import java.util.Random;
import java.util.function.Supplier;

public class Example {
    public static void main(String[] args) {
        // Supplier method implementation that generates random integer value
        Supplier<Integer> randomSupplier = () -> new Random().nextInt();
        int count = 5;

        while (count-- > 0) System.out.println(randomSupplier.get());
    }
}
