package com.tutorial.collections.collection.list;

import java.util.*;

public class ListExample5 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<String> otherList = new ArrayList<>();

        String elem1 = "element 1";
        String elem2 = "element 2";
        String elem3 = "element 3";
        String elem4 = "element 4";
        String elem5 = "element 5";
        String elem6 = "element 6";

        list.add(elem1);
        list.add(elem2);
        list.add(elem3);
        list.add(elem6);

        otherList.add(elem2);
        otherList.add(elem3);
        otherList.add(elem4);
        otherList.add(elem5);

        for (String element :
                list) {
            System.out.println(element);
        }

        System.out.println("after list.retailAll()");

        list.retainAll(otherList);

        for (String element :
                list) {
            System.out.println(element);
        }

        System.out.println("list size is: " + list.size());

        System.out.println("sublist():::");

        list.add("element 7");
        list.add("element 8");

        List<String> sublist = list.subList(2, 4);

        for (String element :
                sublist) {
            System.out.println(element);
        }

        System.out.println("\nList to Set:::");
        list.add("element 8");

        Set set = new HashSet();
        set.addAll(list);

        for (Object o : set) {
            System.out.println(o.toString());
        }

        System.out.println("List to Array::::");

        Object[] objects = list.toArray();

        for (Object object : objects) {
            System.out.println(object);
        }

        System.out.println("Convert a List to an Array of a specific type:::");
        Object[] objects1 = list.toArray(new String[0]);

        for (Object o : objects1) {
            System.out.println(o);
        }

        System.out.println("Array to List:::");

        String[] values = new String[]{"one", "two", "three"};

        //List<String> list1 = (List<String>) Arrays.asList(values);
        List<String> list1 = Arrays.asList(values);
        System.out.println(list1.getClass().getName());
        for (String s : list1) {
            System.out.println(s);
        }

    }
}
