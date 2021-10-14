package com.tutorial.java.collections.iterable;

import java.util.*;

public class IterableExample1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("alpha");
        list.add("beta");
        list.add("gamma");

        Collection<String> collection = list; // List interface extends Collection interface
        Iterable<String> iterable = collection; // Collection interface extends Iterable interface

        for(String element: iterable){
            System.out.println(element);
        }

        Iterator<String> iterator = iterable.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        iterable.forEach((element) -> {
            System.out.println(element);
        });

        Spliterator<String> spliterator = iterable.spliterator();
    }
}
