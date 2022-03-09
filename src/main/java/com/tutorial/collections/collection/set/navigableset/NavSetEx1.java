package com.tutorial.collections.collection.set.navigableset;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class NavSetEx1 {
    public static void main(String[] args) {
        NavigableSet navigableSet = new TreeSet();

        NavigableSet original = new TreeSet();
        original.add("1");
        original.add("2");
        original.add("3");
        original.add("4");
        original.add("5");
        original.add("6");

        System.out.println("original -> " + original);
        // descendingSet()
        NavigableSet reverse = original.descendingSet();
        System.out.println("original.descendingSet() -> " + reverse);

        // descendingIterator()
        System.out.println("original.descendingIterator()::");
        Iterator iterator = original.descendingIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println((SortedSet)original.headSet("4"));
        System.out.println((NavigableSet)original.headSet("4"));


        System.out.println((NavigableSet)original.tailSet("4"));
        System.out.println((NavigableSet)original.tailSet("4", false));

        System.out.println(original.subSet("2", "5"));
        System.out.println(original.subSet("2",true, "5", true));

        System.out.println(original);

        Object ceiling = original.ceiling("3");
        System.out.println(ceiling);

        System.out.println(original.ceiling("3"));
        System.out.println(original.floor("3"));

        System.out.println(original.higher("3"));
        System.out.println(original.lower("3"));

        System.out.println(original.pollFirst());
        System.out.println(original.pollLast());
        System.out.println(original);
    }
}
