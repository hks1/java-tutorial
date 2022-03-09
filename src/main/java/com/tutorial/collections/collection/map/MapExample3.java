package com.tutorial.collections.collection.map;

import java.util.HashMap;
import java.util.Map;

public class MapExample3 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        map.put("abc", new Integer(123));
        System.out.println(map);
        map.put("def", Integer.valueOf(456));
        map.put("def", 789);
        System.out.println(map);
        map.put("ghi", null);
        map.put(null, 013);
        map.put("hexkey", 013);
        map.put("octkey", 013);
        System.out.println(map);
        System.out.println(map.get(null));

        Map<String, Integer> map1 = new HashMap<>();

        map1.putAll(map);

        System.out.println(map1);

        System.out.println(map.size());
        System.out.println(map.size() == 0);
        System.out.println(map.isEmpty());

        System.out.println(map.containsKey("def"));
        System.out.println(map.containsKey("234"));

        System.out.println(map.containsValue(789));
        System.out.println(map.containsValue("23"));

        System.out.println(map1);
        map1.remove("def");
        System.out.println(map1);
        System.out.println(map);
        System.out.println(map1.containsKey("def"));
        System.out.println(map1.get("def"));

        map1.clear();
        System.out.println(map1.size());
    }

}
