package com.lc.problems;

import java.util.*;

public class PrefixSums {
    // 1480. Running Sum of 1d Array
    //Easy
    //
    //2528
    //
    //177
    //
    //Add to List
    //
    //Share
    //Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
    //
    //Return the running sum of nums.
    public int[] runningSum(int[] nums) {
        int runningSum = 0;
        int[] runningSums = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            runningSum += nums[i];
            runningSums[i] = runningSum;
        }
        return runningSums;
    }
    //560. Subarray Sum Equals K
    //Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
    public int subarraySum(int[] nums, int k) {
        // TC: O(n), SC: O(n)
        Map<Integer, Integer> prefixSumSet = new HashMap<>();
        prefixSumSet.put(0, 1);
        int prefixSum = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            prefixSum += nums[i];
            /*if(prefixSumSet.containsKey(prefixSum-k)) {
                count++;
            }*/
            count += prefixSumSet.getOrDefault(prefixSum-k, 0);
            prefixSumSet.put(prefixSum, prefixSumSet.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }

    // 974. Subarray Sums Divisible by K
    //Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.
    //
    //A subarray is a contiguous part of an array.
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(); // stores 'mod k' and frequencies
        map.put(0, 1);
        int count = 0, prefixSum = 0;
        for(int i = 0; i < nums.length; i++){
            //prefixSum += nums[i] % k;
            prefixSum += nums[i];
            count += map.getOrDefault(prefixSum % k, 0);
            map.put(prefixSum % k, map.getOrDefault(prefixSum % k, 0) + 1);
        }
        return count;
    }

    //325. Maximum Size Subarray Sum Equals k
    //Given an integer array nums and an integer k, return the maximum length of a subarray that sums to k. If there is not one, return 0 instead.
    public int maxSubArrayLen(int[] nums, int k) {
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>(); // given any value, what is the smallest prefix (length) adding up to that value
        map.put(0,0);
        int prefixSum = 0;
        for(int i = 0; i < nums.length; i++){
            prefixSum += nums[i];
            if(map.containsKey(prefixSum-k)){
                // i + 1 is the total length of the array upto index i
                max = Math.max(max, i + 1 - map.get(prefixSum-k));
            }
            if(!map.containsKey(prefixSum)){
                map.put(prefixSum, i+1);
            }
        }
        return max;
    }
    public int maxSubArrayLenBruteForce(int[] nums, int k) {
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            int sum = 0;
            for(int j = i; j < nums.length; j++){
                sum += nums[j];
                if(sum == k){
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }

    // 1524. Number of Sub-arrays With Odd Sum
    //Given an array of integers arr, return the number of subarrays with an odd sum.
    //
    //Since the answer can be very large, return it modulo 109 + 7.
    public int numOfSubarrays(int[] arr) {
        int count = 0;
        Map<String, Integer> map = new HashMap<>();
        map.put("even", 1);
        map.put("odd", 0);
        int prefixSum = 0;
        for(int i = 0; i < arr.length; i++){
            // prefixSum(P) = prefix + suffix
            // if P is even: how many prefixes with an odd sum?
            // if P is odd: how many prefixes with an even sum?

            prefixSum += arr[i];
            if(prefixSum % 2 == 0){
                count += map.get("odd");
            } else{
                count += map.get("even");
            }
            count %= Math.pow(10, 9) + 7;
            if(prefixSum % 2 == 0){
                map.put("even", map.get("even") + 1);
            }else{
                map.put("odd", map.get("odd") + 1);
            }
        }
        return count;
    }

    // 525. Contiguous Array
    //Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
    public int findMaxLength(int[] nums) {
        int maxLength = 0;
        Map<Integer, Integer> map = new HashMap<>(); //diff of 0's and 1's and corresponding length when this diff was encountered first time
        map.put(0,0);
        int diff = 0;
        for( int i = 0; i < nums.length; i++){
            if(nums[i] == 1) diff++;
            else diff--;
            if(map.containsKey(diff)){
                maxLength = Math.max(maxLength, i + 1 - map.get(diff));
            }
            if(!map.containsKey(diff)){
                map.put(diff, i+1);
            }
        }
        return maxLength;
    }
    // 523. Continuous Subarray Sum
    //Given an integer array nums and an integer k, return true if nums has a continuous subarray of size at least two whose elements sum up to a multiple of k, or false otherwise.
    //
    //An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.
    public boolean checkSubarraySum(int[] nums, int k) {
        return true;
    }
}

// 303. Range Sum Query - Immutable
//Given an integer array nums, handle multiple queries of the following type:
//
//Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
//Implement the NumArray class:
//
//NumArray(int[] nums) Initializes the object with the integer array nums.
//int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).

class NumArray {

    int[] prefixSums;

    public NumArray(int[] nums) {
        prefixSums = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            prefixSums[i] = (i > 0 ? prefixSums[i-1] : 0) + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return prefixSums[right] - (left > 0 ? prefixSums[left-1] : 0);
    }
}
//304. Range Sum Query 2D - Immutable
//Given a 2D matrix matrix, handle multiple queries of the following type:
//
//Calculate the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
//Implement the NumMatrix class:
//
//NumMatrix(int[][] matrix) Initializes the object with the integer matrix matrix.
//int sumRegion(int row1, int col1, int row2, int col2) Returns the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
//
class NumMatrix{
    int[][] table;
    public NumMatrix(int[][] matrix) {
        table = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            table[i][0] = (i > 0 ? table[i-1][0] : 0) + matrix[i][0];
        }
        for(int j = 0; j < matrix[0].length; j++){
            table[0][j] = (j > 0 ? table[0][j-1] : 0) + matrix[0][j];
        }
        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[i].length; j++){
                table[i][j] = table[i-1][j] + table[i][j-1] - table[i-1][j-1] + matrix[i][j];
            }
        }
    }
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(row1 == 0 && col1 == 0){
            return this.table[row2][col2];
        }
        if(row1 == 0){
            return table[row2][col2] - table[row2][col1-1];
        }
        if(col1 == 0){
            return table[row2][col2] - table[row1-1][col2];
        }
        return table[row2][col2] - table[row1-1][col2] - table[row2][col1-1] + table[row1-1][col1-1];
    }
}

