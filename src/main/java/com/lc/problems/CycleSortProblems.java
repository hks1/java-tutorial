package com.lc.problems;

import java.util.ArrayList;
import java.util.List;

public class CycleSortProblems {
    // 645. Set Mismatch
    // You have a set of integers s, which originally contains all the numbers from 1 to n.
    // Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.
    //
    //You are given an integer array nums representing the data status of this set after the error.
    //
    //Find the number that occurs twice and the number that is missing and return them in the form of an array.
    public int[] findErrorNums(int[] nums){
        for(int i = 0; i < nums.length; i++){
            while(nums[i] != i + 1){
                if(nums[i] != nums[nums[i]]){
                    com.utils.Utils.swap(nums, i, nums[i]);
                } else{
                    break;
                }
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i+1) return new int[]{nums[i], i+1};
        }
        return new int[]{-1,-1};
    }

    // 268. Missing Number
    // Given an array nums containing n distinct numbers in the range [0, n],
    // return the only number in the range that is missing from the array.
    public int missingNumber(int[] arr){
        int missing = arr.length;
        for(int i = 0; i < arr.length; i++){
            missing ^= i ^ arr[i];
            System.out.println(missing + " " + Integer.toBinaryString(missing));
        }
        return missing;
    }
    // range [0,n]
    // will cause integer overflow for large sum
    public int missingNumberGaussFormula(int[] arr){
        int n = arr.length;
        int totalSum = n * (n+1) / 2; //input is first n numbers including 0, array length is n+1
        int arrSum = 0;
        for(int i = 0; i < arr.length; i++){
            arrSum += arr[i];
        }
        return totalSum - arrSum;
    }

    // 287. Find the Duplicate Number
    //Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
    //
    //There is only one repeated number in nums, return this repeated number.
    //
    //You must solve the problem without modifying the array nums and uses only constant extra space.
    public int findDuplicate(int[] arr){
        int n = arr.length - 1;
        int nNumSum = n * (n+1) / 2;
        int arrSum = 0;
        for(int i : arr){
            arrSum += i;
        }
        return arrSum - nNumSum;
    }
    public int findDuplicateCycleSort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            while(arr[i] != i){
                if(arr[i] != arr[arr[i]]){
                    com.utils.Utils.swap(arr, i, arr[i]);
                } else{
                    break;
                }
            }
        }
        return arr[0];
    }

    // 448. find All Numbers disappeared in an array
    // input : array nums of n integers, nums[i] is in the range [1,n]
    public List<Integer> findDisappearedNumbers(int[] nums){
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            while(nums[i] != i-1){
                int d = nums[i] - 1;
                if(nums[i] != nums[d]){
                    com.utils.Utils.swap(nums, i, nums[i]-1);
                }else{
                    break;
                }
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i+1) result.add(i+1);
        }
        return result;
    }

    // 41. First Missing Positive
    // Given an unsorted integer array nums, return the smallest missing positive integer.
    //
    //You must implement an algorithm that runs in O(n) time and uses constant extra space.
    public int firstMissingPositive(int[] arr){
        for(int i = 0; i < arr.length; i++){
            while(arr[i] != i+1){
                int d = arr[i]-1;
                if(d >= 0 && d < arr.length && arr[d] != arr[i]){
                    com.utils.Utils.swap(arr, i, d);
                } else{
                    break;
                }
            }
        }
        for(int i = 0; i < arr.length; i++){
            if(i+1 != arr[i]) return i+1;
        }
        return arr.length+1;
    }

    // 765. Couples Holding Hands
    // There are n couples sitting in 2n seats arranged in a row and want to hold hands.
    //
    //The people and seats are represented by an integer array row where row[i] is the ID of the person sitting in the ith seat. The couples are numbered in order, the first couple being (0, 1), the second couple being (2, 3), and so on with the last couple being (2n - 2, 2n - 1).
    //
    //Return the minimum number of swaps so that every couple is sitting side by side. A swap consists of choosing any two people, then they stand up and switch seats.
    public int minSwapsCouples(int[] rows){
        return 0;
    }
}
