package com.tutorial.java.collections.iterator;

import java.util.*;
import java.util.ListIterator;

public class IteratorExample1 {
    public static void main(String[] args) {
        // Obtaining an iterator for a list
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");

        Iterator<String> iterator = list.iterator();

        // Iterator for a set
        Set<String> set = new HashSet<>();
        set.add("one");
        set.add("two");
        set.add("three");

        Iterator iterator1 = set.iterator();

        // Iterating an iterator
        System.out.println("List iterator::");
        while(iterator.hasNext()){
            String str = iterator.next();
            System.out.println(str);
            //System.out.println(iterator.next());
        }

        System.out.println("Set iterator::");
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }

        // Iterator with Map
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        Iterator<String> keyIterator = map.keySet().iterator();
        Iterator<String> valueIterator = map.values().iterator();

        Iterator<Map.Entry<String, String>> entryIterator = map.entrySet().iterator();

        System.out.println("Map entryIterator::");
        while (entryIterator.hasNext()){
            System.out.println(entryIterator.next());
        }

        // Modification during iteration - ConcurrentModificationException

        // Remove elements during iteration - allowed.
            // The java Iterator interface has a remove() method
                // which lets you remove the element just returned by next() from the underlying collection
        System.out.println("Remove element while iterating::");
        List<String> list1 = new ArrayList<>();
        list1.add("123");
        list1.add("456");
        list1.add("789");
        Iterator<String> iterator2 = list1.iterator();
        while (iterator2.hasNext()){
            String value = iterator2.next();

            if(value.equals("456")){
                iterator2.remove();
            }
        }
        System.out.println("list1 after item removed while iterating:: " + list1.toString());

        // forEachRemaining
        List<String> list2 = new ArrayList();
        list2.add("Heidi");
        list2.add("Jane");
        list2.add("Hannah");

        System.out.println("forEachRemaining dem0:::");
        Iterator<String> iterator3 = list2.iterator();
        iterator3.forEachRemaining((element) -> {
            System.out.println(element);
        });

        // ListIterator - interface, extends iterator
            // represents a bi-directional iterator
        System.out.println("ListIterator - bi-directional iterator:::");
        ListIterator<String> listIterator = list2.listIterator();
        System.out.println("ListIterator - bi-directional iterator::: hasNext()::");
        while(listIterator.hasNext()){
            System.out.println(listIterator.next());
        }
        System.out.println("ListIterator - bi-directional iterator:::hasPrevious()::");
        while (listIterator.hasPrevious()){
            System.out.println(listIterator.previous());
        }
    }


}
