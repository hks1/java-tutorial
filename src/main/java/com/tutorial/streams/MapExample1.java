package com.tutorial.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapExample1 {
    public static void main(String[] args) {
        Integer[] integers = {1, 2, 3, 4, 5, 6, 7, 8};
        List<Integer> integerList = new ArrayList<>(Arrays.asList(integers));
        //multiply each number of the list by 2
        // typical procedural way
        List<Integer> doubled = new ArrayList<>();
        /*
        for(int i = 0; i < integerList.size(); i++){
            Integer result = integerList.get(i) * 2;
            doubled.add(result);
        }
         */
        // Functional way
        Function<Integer, Integer> timesTwo = (x) -> x * 2;
        doubled = integerList
                .stream()
                .map(timesTwo)
                .collect(Collectors.toList());
        System.out.println(doubled);
    }
}
