package com.tutorial.collections.collection.map;

import java.util.HashMap;
import java.util.Map;

public class MapExample7 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("123", "abc");
        map.put("234", "bcd");
        map.put("345", "Word");
        map.put("456", "car!");
        map.put("567", null);
/*
        String val = map.computeIfAbsent("678", ((key) -> "IF-ABSENT-DEMO")); // returns value, "IF-ABSENT-DEMO" in this example
        System.out.println(val);
*/
        map.computeIfAbsent("678", ((key) -> "IF-ABSENT-DEMO"));
        System.out.println(map);

        map.computeIfPresent("234", ((key, value) -> value == null ? null : value.toString().toUpperCase() + "-IF-PRESENT-DEMO"));
        System.out.println(map);

        map.merge("123", "MERGE-DEMO", (oldValue, newValue) -> oldValue + "-" + newValue + "-abc");
        System.out.println(map);
        map.merge("567", "MERGE-DEMO", (oldValue, newValue) -> oldValue + newValue + "-abc");
        System.out.println(map);

    }
}
