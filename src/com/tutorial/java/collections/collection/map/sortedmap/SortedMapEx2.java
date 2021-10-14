package com.tutorial.java.collections.collection.map.sortedmap;

import java.util.Iterator;
import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMapEx2 {
    public static void main(String[] args) {
        SortedMap sortedMap = new TreeMap();

        sortedMap.put("a", "one");
        sortedMap.put("b", "two");
        sortedMap.put("c", "three");

        Iterator iterator = sortedMap.keySet().iterator();

        while (iterator.hasNext()){
            String key = (String) iterator.next();
            //System.out.println(iterator.next());
            System.out.println(sortedMap.get(key));
        }

        //Iterator descendingIterator = sortedMap.descendingKeySet().iterator();?????????????????

        System.out.println("sorted map : " + sortedMap);

        // Get First Key
        String firstKey = (String) sortedMap.firstKey();
        // Get Last Key
        String lastKey = (String) sortedMap.lastKey();
        System.out.println("first key : " + firstKey + ", last key is : " + lastKey);

        sortedMap.put("d", "four");
        sortedMap.put("e", "five");
        sortedMap.put("f", "six");
        sortedMap.put("g", "seven");
        System.out.println("sorted map is : " + sortedMap);

        // Head Map
        SortedMap headMap = sortedMap.headMap("c");
        // Tail Map
        SortedMap tailMap = sortedMap.tailMap("d");
        System.out.println("sortedMap.headMap(\"c\") : " + headMap);
        System.out.println("sortedMap.tailMap(\"d\") : " + tailMap);
        // Submap
        SortedMap subMap = sortedMap.subMap("b", "e");
        System.out.println("sortedMap.subMap(\"b\", \"e\") : " + subMap);
    }
}
