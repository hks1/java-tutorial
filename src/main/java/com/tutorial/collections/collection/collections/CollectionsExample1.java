package com.tutorial.collections.collection.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsExample1 {
    public static void main(String[] args) {
        // addAll()
        List<String> list = new ArrayList<>();

        Collections.addAll(list, "element 1", "element 2", "element 3");
    }
}
