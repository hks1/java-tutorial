package com.tutorial;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Example4 {
    public static void main(String[] args) {
        Map<Object, Object> map = new HashMap<>();
        System.out.println(map instanceof Object);
        System.out.println(map instanceof HashMap);
        System.out.println(map instanceof Map);

        SortedMap<Object, Object> map1 = new TreeMap<>();
        System.out.println(map1 instanceof Map);

        // Note that it is the actual type of the referenced object that is compared against
            // - not the type of the variable referencing the object

        Map<Object, Object> map2 = null;
        //The Java instanceof operator always evaluates to false
            // when a null variable is compared against any class or interface
        System.out.println(map2 instanceof Map);

        // Note that even if the type of map2 variable is Map,
            // and the map2 variable is compared against the Map interface,
            // the result of the comparison is still false.
            // That is because it is not reference type that is compared against the target class or interface,
            // but the actual type of the referenced object.

        // instanceof with pattern matching - java 14 preview
        Object obj = new String("Test instanceof operator patter matching");
        // If the 'obj' variable references an object of type String,
        // the str variable will be bound to that object - cast to a String.
        if (obj instanceof String str){
            System.out.println("instanceof operator with patter matching: " + str.substring(5, 15));
        }

        if(obj instanceof String str && str.startsWith("Test")){
            System.out.println(str + " - starts with Test");
        }
    }
}
