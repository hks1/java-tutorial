package com.tutorial.collections.collection.map.sortedmap;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMapEx1 {
    public static void main(String[] args) {

        // Create a Tree Map
        SortedMap sortedMap = new TreeMap();

        // Create a Tree Map with Comparator
        Comparator comparator = new MyComparator();

        SortedMap sortedMap1 = new TreeMap(comparator);

        // Get Comparator used
        Comparator comparator1 = sortedMap1.comparator();
        System.out.println(comparator1);
    }
}

class MyComparator implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        return o1.toString().compareTo(o2.toString());
    }
}
