package com.tutorial.collections.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListExample3 {

    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();

        // insert null values
        Object element = null;

        list.add(element);
        list.add(null);

        // insert element at specific index
        list.add(1, "element 5");
        list.add(2, "element 6");

        // insert All elements from one list into another
        List<String> source = new ArrayList<>();
        source.add("123");
        source.add("456");

        list.addAll(source);

        Iterator<Object> stringIterator = list.iterator();

        while (stringIterator.hasNext()){
            System.out.println(stringIterator.next());
        }

        // Find element in a list
        System.out.println("indexOf() and lastIndexOf():::");
        String element1 = "123";
        int index1 = list.indexOf(element1);
        System.out.println("index of element: " + element1 + " in the list is : " +index1);
        list.add("789");
        list.add("456");
        String element2 = "456";
        int index2 = list.lastIndexOf(element2);
        System.out.println("index of element: " + element2 + " in the list is : " + index2);
    }
}
