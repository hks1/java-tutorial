package com.tutorial.def;

import java.util.Arrays;

public class Example2 {
    public static void main(String[] args) {
        int[] intArray = new int[9];
        Arrays.fill(intArray, 123);
        System.out.println(Arrays.toString(intArray));
        Arrays.fill(intArray, 3, 7, 234);
        System.out.println(Arrays.toString(intArray));
        int[] ints = {6, 8, 10, 4, 2, 12, 14, 16, 0, 12, 22, 20};
        int index = Arrays.binarySearch(ints, 8);
        System.out.println(ints.length + ", " + index);
        Arrays.sort(ints);
        int key = 5;
        index = Arrays.binarySearch(ints, key);
        System.out.println(key + ", " + Arrays.toString(ints) + ", " +index);
        key = 10;
        index = Arrays.binarySearch(ints, key);
        System.out.println(key + ", " + Arrays.toString(ints) + ", " +index);
        key = 23;
        index = Arrays.binarySearch(ints, key);
        System.out.println(key + ", " + Arrays.toString(ints) + ", " +index);
        key = 2;
        index = Arrays.binarySearch(ints, 0, 4, key);
        System.out.println(key + ", " + "fromIndex: " + 0 + " toIndex: " + 4 + ", " + Arrays.toString(ints) + ", " +index);
        key = 23;
        index = Arrays.binarySearch(ints, 0, 4, key);
        System.out.println(key + ", " + "fromIndex: " + 0 + " toIndex: " + 4 + ", " + Arrays.toString(ints) + ", " +index);
        key = 5;
        index = Arrays.binarySearch(ints, 0, 4, key);
        System.out.println(key + ", " + "fromIndex: " + 0 + " toIndex: " + 4 + ", " + Arrays.toString(ints) + ", " +index);

        int[] ints1 = {1, 2, 3, 4};
        int[] ints2 = {1, 2, 3, 4};
        int[] ints3 = {4, 2, 3, 1};
        System.out.println(Arrays.equals(ints1, ints2));
        System.out.println(Arrays.equals(ints1, ints3));

        // Accessing an Array via Reflection
    }
}
