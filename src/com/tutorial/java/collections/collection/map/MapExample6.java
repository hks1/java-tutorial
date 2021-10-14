package com.tutorial.java.collections.collection.map;

import java.util.HashMap;
import java.util.Map;

public class MapExample6 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("123", "abc");
        map.put("234", "bcd");
        map.put("345", "Word");
        map.put("456", "car!");
        map.put("567", null);

        System.out.println(map);
        map.compute("123", (key, value) -> value == null ? null : value.toUpperCase());
        map.compute("234", (key, value) -> value == null ? null : value.toString().toUpperCase());
        map.compute("345", (key, value) -> value == null ? null : value.toString()+"-Hello!");
        map.compute("456", (key, value) -> value == null ? null : value.toString().replace("!", "e"));
        System.out.println(map);
        map.compute("567", (key, value) -> value == null ? null : value.toUpperCase());
        System.out.println(map);
    }
}
