package com.tutorial.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterExample1 {
    public static void main(String[] args) {
        Integer[] integers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> integerList = new ArrayList<>(Arrays.asList(integers));
        List<Integer> evens = new ArrayList<>();
        // procedural
        /*
        for(int i = 0; i < integerList.size(); i++){
            boolean isEven = integerList.get(i) % 2 == 0;
            if(isEven) evens.add(integerList.get(i));
        }
         */
        // functional
        Predicate<Integer> isEven = (x) -> x % 2 == 0;
        evens = integerList
                .stream()
                .filter(isEven)
                .collect(Collectors.toList());
        System.out.println(evens);

        String[] wordsArr = {"hello", "functional", "Programming", "is", "cool"};
        List<String> words = new ArrayList<>(Arrays.asList(wordsArr));
        Predicate<String> isLongerThan5 = str -> str.length() > 5;
        List<String> longWords = words
                .stream()
                .filter(isLongerThan5)
                .collect(Collectors.toList());
        System.out.println(longWords);

        Function<Integer, Predicate<String>> createLengthTest = (minLength) ->{
            return (str) -> str.length() > minLength;
        } ;
        Predicate<String> isLongerThan3 = createLengthTest.apply(3);
        longWords = words
                .stream()
                .filter(isLongerThan3)
                .collect(Collectors.toList());
        System.out.println(longWords);
    }
}
