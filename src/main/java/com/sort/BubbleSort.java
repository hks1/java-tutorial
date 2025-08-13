package com.sort;

import java.util.Arrays;

public class BubbleSort implements ISort {

    public int[] sort(int[] A){
        int n = A.length;
        for (int i = 0; i < n; i++){
            for (int j = n-1; j > i; j--){
                if (A[j] < A[j-1]){
                    com.utils.Utils.swap(A, i, j);
                }
            }
        }
        return A;
    }

    // moving to com.sort.Main
//    public static void main(String[] args) {
//        int[] A = new int[]{2,4,6,1,3,5};
//        ISort bsort = new BubbleSort();
//        System.out.println(Arrays.toString(bsort.sort(A)));
//    }
}
