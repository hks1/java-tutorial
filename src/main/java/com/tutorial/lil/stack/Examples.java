package com.tutorial.lil.stack;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Examples {

}

class TD{
    public static void main(String[] args) {
        int[] arr = {16, 7, 2, 15, 7, 8, 9};
        System.out.println(Arrays.toString(arr));
        ArrayDeque<Integer> stack = new ArrayDeque<>();


        Algorithms obj = new Algorithms();
        obj.printNextGreaterNumber(arr);
    }
}
