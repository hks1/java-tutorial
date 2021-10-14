package com.tutorial.java.collections.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsExample1 {
    public static void main(String[] args) {
        List<String> items = new ArrayList<String>();

        items.add("one");
        items.add("two");
        items.add("three");

        Stream<String> stream = items.stream();

        // Stream Processing Phases
        //
        //Processing the elements in the stream happens in two steps / phases:
        // 1. Configuration
        // 2. Processing

        // First the stream is configured.
        // The configuration can consist of filters and mappings.
        // These are also referred to as non-terminal operations.

        // Second, the stream is processed.
        // The processing consists of doing something to the filtered and mapped objects.
        // No processing takes place during the configuring calls.
        // Not until a processing method is called on the stream.
        // The stream processing methods are also referred to as terminal operations.

        // stream.filter()
        stream.filter(item -> item.startsWith("t"));

        // The filter() method takes a Predicate as parameter.
        // The Predicate interface contains a function called test()
            // which the lambda expression passed as parameter above is matched against.
        // In other words, the lambda expression implements the Predicate.test() method.

        // The test() method is defined like this:
        //
        //boolean test(T t)  -- takes a single parameter and returns a boolean.

        // Stream.map()
        // It is possible to map the items in a collection to other objects.
        // In other words, for each item in the collection you create a new object based on that item.
        items.stream()
                .map( item -> item.toUpperCase() );

        // Stream.collect()  -- one of the stream processing methods on the Stream interface.
        // When this method is invoked,
            // the filtering and mapping will take place and the object resulting from those actions will be collected.
        List<String> filtered = items.stream()
                .filter( item -> item.startsWith("o") )
                .collect(Collectors.toList());
        System.out.println("filtered : " + filtered);

        // Stream.min() and Stream.max()
        String shortest = items.stream()
                .min(Comparator.comparing(item -> item.length()))
                .get();
        System.out.println("shortest : " + shortest);

        // Stream.count() - returns a long
        long count = items.stream()
                .filter(item -> item.startsWith("t"))
                .count();
        System.out.println("count : " + count);

        // Stream.reduce()
        String reduced2 = items.stream()
                .reduce((acc, item) -> acc + " " + item)
                .get();
        System.out.println("reduced2 : " + reduced2);

        // The reduce() method takes a BinaryOperator as parameter,
            // which can easily be implemented using a lambda expression.
        // The BinaryOperator.apply() method is the method implemented by the lambda expression above.
        // This method takes two parameters.
        // The acc which is the accumulated value,
            // and item which is an element from the stream.
        // Thus, the value created by the reduce() function is the accumulated value after processing the last element in the stream.
        // In the example above, each item is concatenated to the accumulated value.
        // This is done by the lambda expression implementing the BinaryOperator.

        // The reduce() method taking a BinaryOperator as parameter returns an Optional .
        // In case the stream contains no elements, the Optional.get() returns null.
        // Otherwise it returns the reduced value.

        // There is another reduce() method which takes two parameters.
        // It takes an initial value for the accumulated value, and then a BinaryOperator.
        // Here is an example:
        String reduced = items.stream()
                .reduce("", (acc, item) -> acc + " " + item);
        System.out.println("reduced :" + reduced);

        // This version of the reduce() method returns the accumulated value directly, and not an Optional.
        // If the stream contains no elements, the initial value will be returned.

        // reduce() and filter() together
        String reduced3 = items.stream()
                .filter(item -> item.startsWith("t"))
                .reduce("" , (acc, item) -> acc + " " + item);

        System.out.println("reduced3 : " + reduced3);
    }
}
