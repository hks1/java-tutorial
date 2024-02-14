package com.tutorial.arrays;

import java.util.Arrays;

public class RemoveEven {
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
