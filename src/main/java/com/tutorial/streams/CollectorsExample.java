package com.tutorial.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CollectorsExample {
    public static void main(String[] args) {
        String[] wordsArr = {"hello", "apple", "functional", "Programming", "is", "is", "cool"};
        List<String> words = new ArrayList<>(Arrays.asList(wordsArr));

        Function<Integer, Predicate<String>> createLengthTest = (minLength) ->{
            return (str) -> str.length() > minLength;
        } ;
        Predicate<String> isLongerThan3 = createLengthTest.apply(3);
        String longWords = words
                .stream()
                .filter(str -> str.length() > 3)
                .collect(Collectors.joining(","));
        Long howManyLongWords = words
                .stream().count();
        howManyLongWords = words
                .stream()
                .filter(word -> word.length() > 3)
                .collect(Collectors.counting());
        Map<Integer, List<String>> wordLengthMap  = words
                .stream()
                //.filter(word -> word.length() > 3)
                .collect(Collectors.groupingBy(
                        (word) -> word.length()
                ));
        Map<Boolean, List<String>> wordLengthPartitionedMap  = words
                .stream()
                .collect(Collectors.partitioningBy(
                        (word) -> word.length() > 5
                ));
    }
}
