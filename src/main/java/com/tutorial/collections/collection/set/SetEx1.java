package com.tutorial.collections.collection.set;

import java.util.*;
import java.util.stream.Stream;

public class SetEx1 {
    public static void main(String[] args) {
        Set set = new HashSet(); // HashSet does not order its elements internally

        Set set1 = new TreeSet(); // TreeSet does order its elements internally

        Set set4 = new LinkedHashSet();  // Order of elements during insertion is the same as the order they were inserted

        set4.add("linked");
        set4.add("hash");
        set4.add("set");
        System.out.println("LinkedHashSet " + set4);


        Set<String> set2 = new HashSet<>();

        boolean added = set2.add("alpha");
        boolean added2 = set2.add("alpha");
        System.out.println("added: " + added);
        System.out.println("added2: " + added2);
        set2.add("delta");

        Set<String> set3 = Set.of("Hello", "World", "1", "2", "3");

        for (String s : set3) {
            System.out.println(s);
        }

        System.out.println("Iterate through set3 using stream::");
        Stream<String> stream = set3.stream();

        stream
                .forEach(element -> System.out.println(element));
    }
}
