package com.tutorial.arrays;

import java.util.Arrays;

public class ArrayProblems {
    public int[] removeEven(int[] arr){
        int index = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] % 2 == 1){
                com.utils.Utils.swap(arr, i, index++);
            }
        }
        int[] result = Arrays.copyOfRange(arr, 0, index);
        return result;
    }
}

class TDArrayProblems{
    public static void main(String[] args) {
        ArrayProblems obj = new ArrayProblems();
        System.out.println(Arrays.toString(obj.removeEven(new int[]{1,2,4,5,10,6,3})));
    }
}
