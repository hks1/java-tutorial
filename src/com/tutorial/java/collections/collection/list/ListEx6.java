package com.tutorial.java.collections.collection.list;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

// Iterate a list using Java stream API
public class ListEx6 {
    public static void main(String[] args) {
        System.out.println("Iterate a List using Java Stream API::::");

        List<String> list = new ArrayList<>();

        list.add("alpha");
        list.add("beta");
        list.add("gama");

        Stream<String> stream = list.stream();

        stream
                .forEach(element -> System.out.println(element));
    }
}
