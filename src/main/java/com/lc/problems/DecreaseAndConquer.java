package com.lc.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DecreaseAndConquer {
    //969. Pancake Sorting
    //Given an array of integers arr, sort the array by performing a series of pancake flips.
    //
    //In one pancake flip we do the following steps:
    //
    //Choose an integer k where 1 <= k <= arr.length.
    //Reverse the sub-array arr[0...k-1] (0-indexed).
    //For example, if arr = [3,2,1,4] and we performed a pancake flip choosing k = 3, we reverse the sub-array [3,2,1], so arr = [1,2,3,4] after the pancake flip at k = 3.
    //
    //Return an array of the k-values corresponding to a sequence of pancake flips that sort arr. Any valid answer that sorts the array within 10 * arr.length flips will be judged as correct.
    public List<Integer> pancakeSort(int[] arr){
        List<Integer> result = new ArrayList<>();
        return result;
    }
    // 280. Wiggle Sort
    //Given an integer array nums, reorder it such that nums[0] <= nums[1] >= nums[2] <= nums[3]....
    //
    //You may assume the input array always has a valid answer.
    public void wiggleSort(int[] arr){
        // nums[0] <= nums[1] >= nums[2] <= nums[3]...
        for(int i = 1; i < arr.length; i++){
            if((i%2 == 1 && arr[i-1] > arr[i])
                || (i%2 == 0 && arr[i-1] < arr[i])){
                com.utils.Utils.swap(arr, i-1, i);
            }
        }
    }
    // 240. Search a 2D Matrix II
    //Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:
    //
    //Integers in each row are sorted in ascending from left to right.
    //Integers in each column are sorted in ascending from top to bottom.
    // O(m+n)
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix.length-1;
        while(row < matrix.length && col >= 0){
            if(matrix[row][col] == target){
                return true;
            }else if(matrix[row][col] > target){
                col--;
            } else{
                row++;
            }
        }
        return false;
    }

    // 277. Find the Celebrity
    //Suppose you are at a party with n people labeled from 0 to n - 1 and among them, there may exist one celebrity. The definition of a celebrity is that all the other n - 1 people know the celebrity, but the celebrity does not know any of them.
    //
    //Now you want to find out who the celebrity is or verify that there is not one. The only thing you are allowed to do is ask questions like: "Hi, A. Do you know B?" to get information about whether A knows B. You need to find out the celebrity (or verify there is not one) by asking as few questions as possible (in the asymptotic sense).
    //
    //You are given a helper function bool knows(a, b) that tells you whether A knows B. Implement a function int findCelebrity(n). There will be exactly one celebrity if they are at the party.
    //
    //Return the celebrity's label if there is a celebrity at the party. If there is no celebrity, return -1.
    public int findCelebrity(int n) {
        return 0;
    }

    // 53. Maximum Subarray
    //Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
    //
    //A subarray is a contiguous part of an array.
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for(int i = 0; i < nums.length; i++){
            currSum = Math.max(currSum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }

    //121. Best Time to Buy and Sell Stock
    //You are given an array prices where prices[i] is the price of a given stock on the ith day.
    //
    //You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
    //
    //Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for(int i = 0;i < prices.length; i++){
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        return maxProfit;
    }

    // 221. Maximal Square
    //Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
    public int maximalSquare(char[][] matrix) {
        return 0;
    }
}

class TDDecreaseAndConquer{
    public static void main(String[] args) {
        DecreaseAndConquer obj = new DecreaseAndConquer();
        int[] arr = new int[]{1,2,2,1,2,1,1,1,1,3,2,2};
        obj.wiggleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
