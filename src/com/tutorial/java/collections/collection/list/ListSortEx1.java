package com.tutorial.java.collections.collection.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListSortEx1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("one");
        list.add("two");
        list.add("three");

        Collections.sort(list);

        System.out.println("Sorted list::::");

        for (String s : list) {
            System.out.println(s);
        }
    }
}
