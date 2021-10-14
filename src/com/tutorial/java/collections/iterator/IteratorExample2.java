package com.tutorial.java.collections.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// iterator without generic type - need to cast the value retrieved

public class IteratorExample2 {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("Marry");
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            String next = (String) iterator.next();
            //System.out.println(iterator.next());
            System.out.println(next);
        }
    }
}
