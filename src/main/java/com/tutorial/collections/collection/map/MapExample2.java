package com.tutorial.collections.collection.map;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MapExample2 {
    public static void main(String[] args) {
        Map<String, String> hashMap = new HashMap<>();
        Map<String, String> treeMap = new TreeMap<>();

        Map<String, String> hashTable = new Hashtable<>();

        Map<String, String> concurrentMap = new ConcurrentHashMap<>();

        SortedMap sortedMap = new TreeMap();
    }
}
