package com.tutorial.arrays;

import java.util.Arrays;
import java.util.OptionalInt;

public class Search {
    public OptionalInt linearSearch(int[] arr, int item){
        return Arrays.stream(arr).filter(x -> x == item).findFirst();

    }

    public OptionalInt binarySearch(int[] arr, int item){
        int start = 0;
        int end = arr.length - 1;
        while (start <= end){
            int mid = start + (end - start)/2;
            if(item == arr[mid]){
                return OptionalInt.of(mid);
            } else if (item > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return OptionalInt.empty();
    }
}
class ArraySearchTD{
    public static void main(String[] args) {
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        arr[7] = 1;
        System.out.println(Arrays.toString(arr));

        Search obj = new Search();
        obj.linearSearch(arr, 1).ifPresent(System.out::println);
        obj.linearSearch(arr, 9).ifPresentOrElse(System.out::println, System.out::println);

        obj.linearSearch(arr, 9).ifPresentOrElse(value -> System.out.println(value),
                () -> System.out.println("value not present."));
        obj.linearSearch(arr, 9).ifPresentOrElse(value -> System.out.println(value),
                () -> System.out.println("value not present." ));

    }
}
