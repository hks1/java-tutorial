package com.tutorial.stream.example;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ReverseWords {
    public String reverseWords(String s) {
        return Arrays.stream(s.split(" "))
                .map(word -> new StringBuilder(word).reverse().toString())
                .collect(Collectors.joining(" "));
    }
}
