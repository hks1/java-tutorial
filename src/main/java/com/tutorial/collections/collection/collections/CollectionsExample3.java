package com.tutorial.collections.collection.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CollectionsExample3 {
    public static void main(String[] args) {
        List<String> source = new ArrayList<>();
        Collections.addAll(source, "e1", "e2", "e3");

        List<String> destination = new ArrayList<>();
        Collections.copy(destination, source);
        Iterator<String> iterator = destination.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
