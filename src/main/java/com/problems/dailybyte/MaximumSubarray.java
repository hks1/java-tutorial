package com.problems.dailybyte;
/*
Given an integer array, return the sum of its contiguous subarray that produces the largest value.
Note: Your subarray must contain at least one value.

 */
public class MaximumSubarray {
    public int maxSum(int[] arr){
        int max = Integer.MIN_VALUE;
        int currRunningTotal = 0;
        for (int num :
                arr) {
            currRunningTotal = Math.max(currRunningTotal + num, num);
            max = Math.max(currRunningTotal, max);
        }
        return max;
    }
}
