package com.tutorial.collections.collection.set;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

public class SetEx2 {
    public static void main(String[] args) {

        Set<String> set = new TreeSet<>();
        set.add("4");
        set.add("Hello");
        set.add("World");
        set.add("1");
        set.add("2");
        set.add("3");

        // Stream
        Stream<String> stream = set.stream();

        stream
                .forEach(element -> System.out.println(element));

        // remove() & clear()
        System.out.println("remove() and clear()::");
        boolean removed1 = set.remove("1");
        boolean removedYes = set.remove("yes");

        System.out.println("removed1: " + removed1);
        System.out.println("removedYes: " + removedYes);

        set.clear();

        // isEmpty()
        System.out.println(set.isEmpty());

        // addAll(), removeAll(), retainAll()
        // Set.of()
        System.out.println("addAll()::");

        set.add("1");
        set.add("2");

        set.addAll(Set.of("1", "0", "abc"));

        System.out.println(set);

        System.out.println("removeAll()::");
        set.removeAll(Set.of("1", "9", "abc"));

        System.out.println(set);

        System.out.println("retainAll()::");
        set.add("1");
        set.add("demo");

        set.retainAll(Set.of("0", "demo", "7"));
        System.out.println(set);

        int size = set.size();

        System.out.println("size of set is: " + set.size());

        System.out.println("isEmpty()::");
        boolean isEmpty = set.isEmpty();

        System.out.println(isEmpty);

        // contains()
        System.out.println("contains():::");

        boolean contains1 = set.contains("1");
        System.out.println(contains1);

        // Since Java 9 the Set interface contains a set of static factory methods
            // that can create unmodifiable (Immutable) Set instances.
        System.out.println("Set.of()::: (with and without generic type specified)---");
        Set set1 = Set.of();  // with no generic type specified

        Set<String> set2 = Set.of("set", "dot", "of", "demo"); // with generic type specified
        System.out.println(set2);

        Set<String> set3 = Set.<String>of("set", "dot", "of", "demo"); // // with generic type specified
        System.out.println(set3);

        //set3.add("add element");  // UnSupportedOperationException



    }
}
