package com.problems.ik;

import static com.utils.Utils.swap;

// Segregate Even and Odd Numbers
/*
Given an array of numbers, rearrange them in-place so that even numbers appear before odd ones.
Example:
{
"numbers": [1, 2, 3, 4]
}
Output:
[4, 2, 3, 1]
 */
public class EvenOdd {
    public int[] segregateEvenOdd(int[] arr){
        int even = -1;
        for(int i = 0; i < arr.length; i++){
            if(arr[i]%2 == 0){
                swap(arr,i,++even);
            }
        }
        return arr;
    }

}
