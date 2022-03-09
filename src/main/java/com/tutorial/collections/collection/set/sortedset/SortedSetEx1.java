package com.tutorial.collections.collection.set.sortedset;

import java.util.*;

public class SortedSetEx1 {
    public static void main(String[] args) {
        SortedSet sortedSet = new TreeSet();

        // Create a TreeSet with a Comparator

        Comparator comparator = new MyComparatorImpl();

        SortedSet sortedSet1 = new TreeSet(comparator);

        // Ascending vs. Descending Sort Order

        TreeSet treeSet = new TreeSet();

        treeSet.add("demo 1");
        treeSet.add("demo 2");
        treeSet.add("demo 3");

        // By default the elements of a SortedSet are iterated in ascending order
        System.out.println("By default the elements of a SortedSet are iterated in ascending order::");
        for (Object o : treeSet) {
            System.out.println(o);
        }

        // It's possible to iterate the elements in descending order using the method TreeSet.descendingIterator()
        System.out.println("\nIt's possible to iterate the elements in descending order using the method TreeSet.descendingIterator():::");
        Iterator iterator = treeSet.descendingIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        // Get Comparator used
        Comparator comparator1 = sortedSet1.comparator();
        System.out.println(comparator1);

        // Get first and last element of a SortedSet
        System.out.println("SortedSet is: " + treeSet);
        System.out.println("first element is : " + treeSet.first());
        System.out.println("last element is : " + treeSet.last());
    }
}

class MyComparatorImpl implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }
}
