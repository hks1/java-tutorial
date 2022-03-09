package com.tutorial.collections.collection.map.navigablemap;

import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.TreeMap;

public class NavMapEx1 {
    public static void main(String[] args) {

        // Create Navigable Map
        NavigableMap navigableMap = new TreeMap();

        navigableMap.put("1", "one");
        navigableMap.put("2", "two");
        navigableMap.put("3", "three");

        navigableMap.put("4", "four");
        navigableMap.put("5", "five");
        navigableMap.put("6", "six");
        navigableMap.put("7", "seven");

        // Create a Navigable Map with  Comparator

        System.out.println("navigableMap : " + navigableMap );
        // descendingKeySet()
        NavigableSet reverse = navigableMap.descendingKeySet();
        System.out.println("navigableMap.descendingKeySet() : " + reverse);

        // descendingMap()
        NavigableMap descending = navigableMap.descendingMap();
        System.out.println("navigableMap.descendingMap() : " + descending);

        // headMap()
        // tailMap()
        // subMap()
        NavigableMap submap = navigableMap.subMap("b", true, "d", true);
        System.out.println("navigableMap.subMap(\"b\", true, \"d\", true) : " + submap);

        // Below methods return key object
        // ceilingKey()
        // floorKey()
        // higherKey()
        // lowerKey()
        Object ceilingKey = navigableMap.ceilingKey("2");
        System.out.println("navigableMap.ceilingKey(\"2\") : " + ceilingKey);
        Object floorKey = navigableMap.floorKey("2");
        System.out.println("navigableMap.floorKey(\"2\") : " + floorKey);
        Object higherKey = navigableMap.higherKey("2");
        System.out.println("navigableMap.higherKey(\"2\") : " + higherKey);
        Object lowerKey = navigableMap.lowerKey("2");
        System.out.println("navigableMap.lowerKey(\"2\") : " + lowerKey);

        // below methods return a Map.Entry.
            // A Map.Entry maps a single key to a single value
        //ceilingEntry()
        // floorEntry()
        // higherEntry()
        // lowerEntry()
        Map.Entry ceilingEntry = navigableMap.ceilingEntry("2");
        System.out.println("navigableMap.ceilingEntry(\"2\") : " + ceilingEntry);
        Map.Entry floorEntry = navigableMap.floorEntry("2");
        System.out.println("navigableMap.floorEntry(\"2\") : " + floorEntry);
        Map.Entry higherEntry = navigableMap.higherEntry("2");
        System.out.println("navigableMap.higherEntry(\"2\") : " + higherEntry);
        Map.Entry lowerEntry = navigableMap.lowerEntry("2");
        System.out.println("navigableMap.lowerEntry(\"2\") : " + lowerEntry);

        // pollFirstEntry()
        // pollLastEntry()
        Map.Entry first = navigableMap.pollFirstEntry();
        System.out.println("navigableMap.pollFirstEntry() : " + first);
        System.out.println("navigableMap : " + navigableMap);

        Map.Entry last = navigableMap.pollLastEntry();
        System.out.println("navigableMap.pollLastEntry() : " + last);
        System.out.println("navigableMap : " + navigableMap);


    }
}
