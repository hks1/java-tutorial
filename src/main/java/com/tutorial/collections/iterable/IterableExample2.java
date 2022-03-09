package com.tutorial.collections.iterable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IterableExample2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("theta");
        list.add("delta");

        System.out.println("\n==XXX==");
        for (String element : list){
            System.out.println(element);
        }

        System.out.println("\n==YY==");
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("\n==ZZ==");
        list.forEach((element) -> {
            System.out.println(element);
        });

        System.out.println("\nfor loop::");
        for(int i = 0, n = list.size(); i<n; i++){
            System.out.println(list.get(i));
        }
    }
}
