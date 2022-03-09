package com.tutorial.collections.collection.set.sortedset;

import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetEx2 {
    public static void main(String[] args) {
        SortedSet sortedSet = new TreeSet();

        sortedSet.add("a");
        sortedSet.add("b");
        sortedSet.add("c");
        sortedSet.add("d");
        sortedSet.add("e");
        sortedSet.add("f");

        System.out.println("sortedSet-> " + sortedSet);
        // headSet() and tailSet()
        SortedSet headSet = sortedSet.headSet("c");
        System.out.println("sortedSet.headSet(\"c\")-> " + headSet);
        System.out.println("sortedSet.tailSet(\"d\")-> " + sortedSet.tailSet("d"));

        // subSet()
        SortedSet subSet = sortedSet.subSet("b", "e");
        System.out.println("sortedSet.subSet(\"b\", \"e\")-> " + subSet);
    }
}
