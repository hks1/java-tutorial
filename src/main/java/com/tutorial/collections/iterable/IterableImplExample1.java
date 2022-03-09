package com.tutorial.collections.iterable;

import java.util.Iterator;
import java.util.Spliterator;

public class IterableImplExample1 {
    public static void main(String[] args) {
        IterableImpl customIterable = new IterableImpl();
        customIterable.add("alpha");
        customIterable.add("beta");

        System.out.println("==custom interable");
        for (String element: customIterable) {
            System.out.println(element);
        }

        Iterator<String> iterator = customIterable.iterator();
        Spliterator<String> spliterator = customIterable.spliterator();

        System.out.println("==forEach==");
        customIterable.forEach((element) -> {
            System.out.println(element);
        });
    }
}
