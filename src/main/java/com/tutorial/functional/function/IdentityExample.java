package com.tutorial.functional.function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class IdentityExample {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(1,2,3,4,5));

        list.stream()
                .map(Function.identity()) // <- This,
                .map(i -> i) // <-
                .collect(Collectors.toMap(
                        Function.identity(), // <-- And this,
                        i -> i // <-- is the same as this.
                ))
                .entrySet()
                .stream().iterator()
                .forEachRemaining(e -> System.out.println("k:" + e.getKey() + ", v:" + e.getValue()));
    }
}
