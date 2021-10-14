package com.tutorial.java.generics;

import java.util.ArrayList;
import java.util.Arrays;

public class GenericExample4 {
    // primitive type array can be passed to the type parameter because arrays are reference type.
    public static void main(String[] args) {
        ArrayList<int[]> a = new ArrayList<>();
        a.add(new int[]{1, 2, 3});
        System.out.println(Arrays.toString(a.get(0)));
    }
}
