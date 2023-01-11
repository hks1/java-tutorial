package com.problems.dailybyte;

public class IndexEqualsValue {
    /*
    Given a sorted integer array, nums, return the index within nums that the index is equal to the value at that index.
    If no such index exists, return -1.
     */
    public int indexEqualsValue(int[] nums){
        int numIterations = 0;
        for (int i = 0; i < nums.length; i++){
            //System.out.println("current index: " + i);
            numIterations = i;
            if(nums[i] == i){
                System.out.println("Num iterations: " + numIterations);
                return i;
            }
            if(nums[i] >= nums.length){
                break;
            }
        }
        System.out.println("Num iterations: " + numIterations);
        return -1;
    }
}
