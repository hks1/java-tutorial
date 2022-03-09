package com.tutorial.collections.collection.set;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

// Convert a Set to a List
public class SetEx3 {
    public static void main(String[] args) {
        System.out.println("Converting a Set to a List::::");

        Set<String> set = new TreeSet<>();
        set.add("set");
        set.add("to");
        set.add("list");
        set.add("demo");

        System.out.println("Set is : " + set);

        List<String> list = new ArrayList<>();
        list.addAll(set);

        System.out.println("List is : " + list);
    }
}
