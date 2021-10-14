package com.tutorial.java.collections.collection.map;

import java.util.HashMap;
import java.util.Map;

public class MapExample4 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("1", "Austin");
        map.put("2", "Brzer");

        System.out.println(map);
        String oldValue = map.replace("2", "Becky");
        System.out.println(oldValue);
        System.out.println(map);

    }
}
