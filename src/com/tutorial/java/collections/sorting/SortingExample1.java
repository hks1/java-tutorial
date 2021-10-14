package com.tutorial.java.collections.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingExample1 {
    public static void main(String[] args) {
        List list = new ArrayList<>();

        // Add elements to the list
        list.add("elem11");
        list.add("elem2");
        list.add("elem1");
        list.add("elem3");

        System.out.println("list -> " + list);

        Collections.sort(list);
        System.out.println("sorted list -> " + list);
    }
}
