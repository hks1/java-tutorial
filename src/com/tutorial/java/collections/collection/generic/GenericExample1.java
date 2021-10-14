package com.tutorial.java.collections.collection.generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class GenericExample1 {
    public static void main(String[] args) {
        Collection<String> stringCollection = new ArrayList<>();

        Iterator<String> stringIterator = stringCollection.iterator();

        System.out.println(stringIterator.getClass().getName());
        System.out.println(stringCollection.getClass().getName());
        System.out.println(stringCollection.getClass());

        Collection<Integer> integers = null;
        try {
            System.out.println(integers.getClass().getName());
        } catch (NullPointerException exception){
            System.out.println(exception.fillInStackTrace());
        }
        System.out.println("Continue with the program");

        stringCollection.add("test demo");

        Iterator iterator = stringCollection.iterator();
        System.out.println(iterator.getClass().getName());

        while (iterator.hasNext()){
            System.out.println(iterator.next().getClass().getName());
        }

        Collection<String> stringCollection1 = new HashSet<>();
        stringCollection1.add("test demoo");

        for (String element :
                stringCollection1) {
            System.out.println(element.getClass().getName() + ", " + element);
        }

    }
}
