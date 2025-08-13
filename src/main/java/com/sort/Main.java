package com.sort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] A = new int[]{2,4,6,1,3,5};
//        ISort sort = new SelectionSort();
//        ISort sort = new BubbleSort();
        ISort sort = new InsertionSort();
        System.out.println(Arrays.toString(sort.sort(A)));
    }
}
