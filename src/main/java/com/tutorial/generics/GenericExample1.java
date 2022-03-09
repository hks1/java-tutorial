package com.tutorial.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GenericExample1 {

    // Java Generic Methods
    public static <T> T addAndReturn(T element, Collection<T> collection){
        collection.add(element);
        return element;
    }

    public static void main(String[] args) {
        String stringElement = "stringElement";
        List<String> stringList = new ArrayList<>();

        String theStrElement = addAndReturn(stringElement, stringList);

        System.out.println("theStrElement: " + theStrElement +  ", stringList: " + stringList);

        Integer integerElement = new Integer(123);
        List<Integer> integerList = new ArrayList<>();

        Integer theIntElement = addAndReturn(integerElement, integerList);
        System.out.println("theIntElement: " + theIntElement +  ", integerList: " + integerList);
    }
}
