package com.tutorial.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class ParallelStreamExample {
    public static void main(String[] args) {
        String[] wordsArr = {"hello", "apple", "is", "different", "from", "banana"};
        List<String> words = new ArrayList<>(Arrays.asList(wordsArr));

        List<String> processedWords = words
                .parallelStream()
                .map((word) ->{
                    System.out.println("Upper casing " + word);
                    return word.toUpperCase(Locale.ROOT);
                })
                .map((word) -> {
                    System.out.println("Adding exclamation point to " + word);
                    return word + "!";
                })
                .collect(Collectors.toList());
        System.out.println(processedWords);
    }
}
