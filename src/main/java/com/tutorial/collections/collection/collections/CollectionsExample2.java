package com.tutorial.collections.collection.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsExample2 {

    // binarySearch()
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");

        Collections.sort(list);

        int index = Collections.binarySearch(list, "four");

        System.out.println(index);
    }
}
