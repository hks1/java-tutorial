package com.tutorial.collections.collection.collections;

import java.util.*;

public class CollectionsExample4 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");

        System.out.println("reverse()::::::::");

        Collections.reverse(list);

        Iterator<String> iterator = list.iterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("shuffle():::::::::");
        Collections.shuffle(list);

        iterator = list.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("sort():::::::::");
        Collections.sort(list);

        iterator = list.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("min()::::::");
        List source  = new ArrayList();
        source.add("1");
        source.add("2");
        source.add("3");

        String min = (String) Collections.min(source);

        System.out.println(min);

        System.out.println("max():::::::");
        String max = (String) Collections.max(source);

        System.out.println(max);

        System.out.println("replaceAll():::::::");

        list.add("A");
        list.add("B");
        list.add("A");

/*
        iterator = list.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
*/

        boolean replaceAny = Collections.replaceAll(list, "A", "C");
        System.out.println(replaceAny);

        System.out.println("unmodifiableSet():::::::");

        Set normatSet = new HashSet();
        normatSet.add("one");
        normatSet.add("two");
        normatSet.add("three");

        Set immutableSet = Collections.unmodifiableSet(normatSet);

        Iterator iterator1 = immutableSet.iterator();

        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }

        System.out.println("after modifying source, unmodifiableSet():::::::");
        //immutableSet.add("four");
        normatSet.add("four");

        iterator1 = immutableSet.iterator();

        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
    }
}
