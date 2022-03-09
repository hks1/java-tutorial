package com.tutorial.collections.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListExample4 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        String element1 = "element 1";

        list.add(element1);

        boolean containsElement = list.contains(element1);
        System.out.println(containsElement);

        // To determine if the List contains the element,
        // the list will internally iterate its elements and compare each element to the object passed as parameter.
        // The comparison uses the Java equals method of the element to check if the element is equal to the parameter

        // if the input parameter to contains() is null,
        // the contains() method will not use the equals() method to compare against each element,
        // but rather use == operator
        list.add(null);

        containsElement = list.contains(null);

        System.out.println(containsElement);

        System.out.println("remove(Object element), remove(int index), and clear() :::::::");
        String elem10 = "element 10";
        list.add(elem10);

        int index1 = list.indexOf(elem10);
        System.out.println("indexOf element, " + elem10 + ", is: " + index1);

        list.remove(elem10);
        System.out.println("element at index 0 is: " + list.get(0));
        list.remove(0);

        Iterator iterator = list.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        list.add("element 5");

        list.clear();
    }
}
