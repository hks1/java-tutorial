package com.tutorial.java.collections.collection.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class MapExample5 {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        map.put(101, "Jonathan");
        map.put(201, "Annie");
        map.put(301, "Black Widow");

        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            Integer nextKey = iterator.next();
            //System.out.println(iterator.next());
            System.out.println(nextKey + " : " + map.get(nextKey));
        }

        // forEach
        System.out.println("==========forEach()=============");
        for (Integer key :
                map.keySet()) {
            System.out.println(key + " : " + map.get(key));
        }

        // streams
        System.out.println("=== Using a entry set stream ===");
        map.entrySet().stream().forEach((Map.Entry<Integer, String> entry) -> {
            System.out.println(entry.getKey() + " : " + entry.getValue() );
            //System.out.println(entry.getValue());
        });

        System.out.println("=== Using a key stream ===");
        Stream stream = map.keySet().stream();
        stream.forEach(key -> System.out.println(key + " : " + map.get(key)));

        System.out.println("=== Iterating values, using value iterator ===");
        Iterator<String> iterator1 = map.values().iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }

        System.out.println("=== Using value for-each loop ===");
        for (String value :
                map.values()) {
            System.out.println(value);
        }

        System.out.println("=== Using an entry iterator ===");
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        Iterator<Map.Entry<Integer, String>> iterator2 = entries.iterator();
        while (iterator2.hasNext()){
            Map.Entry<Integer, String> entry = iterator2.next();
            Integer key = entry.getKey();
            String value = entry.getValue();
        }

        System.out.println("== Using an Entry For-Each loop ===");
        for (Map.Entry<Integer, String> entry :
                map.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
        }

        System.out.println("=== Using value stream ===");
        Stream<String> stream1 = map.values().stream();
        stream1.forEach(value -> System.out.println(value));

        // getOrDefault() - returns default value in case no value for the given key.
        System.out.println("===getOrDefault()===");
        System.out.println(map.getOrDefault(401, "Anonymous"));
    }
}
