package com.sort;

import java.util.Arrays;

public class SelectionSort implements ISort{
    public int[] sort(int[] A){

        for (int i = 0; i < A.length; i++){
            int minVal = A[i];
            int minIndex = i;
            for (int j = i+1; j < A.length; j++){
                if(A[j] < minVal){
                    minVal = A[j];
                    minIndex = j;
                }
            }
//            System.out.println("i: " + i + ", j: " + j +", " + ", minIndex: " + minIndex + ", " +Arrays.toString(A));
            com.utils.Utils.swap(A, i, minIndex);
        }
        return A;
    }



    // moving to com.sort.Main
//    public static void main(String[] args) {
//        int[] A = new int[]{2,4,6,1,3,5};
//        ISort ssort = new SelectionSort();
//        System.out.println(Arrays.toString(ssort.sort(A)));
//    }
}
