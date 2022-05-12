package com.problems;

import java.util.Arrays;

public class BinarySearchVariantsOne {
    //704. Binary Search
    //Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
    //
    //You must write an algorithm with O(log n) runtime complexity.
    public int binarySearch(int[] nums, int target){
        int start = 0;
        int end = nums.length-1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                start = mid + 1;
            } else {
                end = mid-1;
            }
        }
        return -1;
    }

    // recursive binary search
    // need to be fixed for failing edge case when element not found
    public int recBinarySearch(int[] nums, int target){
        return helper(nums, 0, nums.length-1, target);
    }

    public int helper(int[] nums, int start, int end, int target){
        if(start > end){
            return -1;
        }
        int mid = start + (end-start)/2;
        if(nums[mid] == target) return mid;
        if(nums[mid] < target){
            return helper(nums, mid+1, end, target);
        }
        else{
            return helper(nums, start, mid-1, target);
        }
    }

    // first bad instance in [G,G,G,G,B,B,B,B,B]
    public int firstBad(char[] arr){
        int start = 0;
        int end = arr.length-1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(arr[mid] == 'B'){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return start;
    }

    // 35. Search Insert Position
    //Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
    //
    //You must write an algorithm with O(log n) runtime complexity.
    public int insertSearch(int[] nums, int target){
        int start = 0;
        int end = nums.length-1;
        while (start <= end){
            int mid = start + (end-start)/2;
            if(nums[mid]== target) return mid;
            if(nums[mid] < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return start;
    }

    // 744. Find Smallest Letter Greater Than Target
    //Given a characters array letters that is sorted in non-decreasing order and a character target, return the smallest character in the array that is larger than target.
    //
    //Note that the letters wrap around.
    //
    //For example, if target == 'z' and letters == ['a', 'b'], the answer is 'a'.
    public char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length-1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(letters[mid] <= target){ // pay attention to '='
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return letters[start%letters.length];
    }

    // 34. Find First and Last Position of Element in Sorted Array
    //Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
    //
    //If target is not found in the array, return [-1, -1].
    //
    //You must write an algorithm with O(log n) runtime complexity.
    public int[] searchRange(int[] nums, int target){
        if(nums.length == 0){
            return new int[]{-1,-1};
        }
        int[] result = new int[2];
        int start = 0;
        int end = nums.length - 1;
        // find start of range
        while(start <= end){
            int mid = start + (end-start)/2;
            if(nums[mid] < target){
                start = mid + 1;
            }else{
                end = mid -1;
            }
        }
        if(start >= nums.length || nums[start] != target){
            return new int[]{-1,-1};
        }
        result[0] = start;
        end = nums.length - 1;
        while(start <= end){
            int mid = start  + (end-start)/2;
            if(nums[mid] <= target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        result[1] = end;
        return result;
    }

    // 1150. Check If a Number Is Majority Element in a Sorted Array
    //Given an integer array nums sorted in non-decreasing order and an integer target, return true if target is a majority element, or false otherwise.
    //
    //A majority element in an array nums is an element that appears more than nums.length / 2 times in the array.
    public boolean isMajorityElement(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(nums[mid] < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        if(start == nums.length || nums[start] != target){
            return false;
        }
        return start < (nums.length-1)/2 && nums[start + nums.length/2] == target;
    }

    // 74. Search a 2D Matrix
    //Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:
    //
    //Integers in each row are sorted from left to right.
    //The first integer of each row is greater than the last integer of the previous row.
    // time complexity: O(log mn)
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0) {
            return false;
        }
        int n = matrix[0].length;
        int start = 0;
        int end = m*n - 1;
        while(start <= end){
            int mid = start + (end-start)/2;
            // mid = row# * n + col
            int row = mid / n;
            int col = mid % n;
            if(matrix[row][col] == target){
                return true;
            }
            if(matrix[row][col] < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return false;
    }

    // 1064. Fixed Point
    //Given an array of distinct integers arr, where arr is sorted in ascending order, return the smallest index i that satisfies arr[i] == i. If there is no such index, return -1.
    public int fixedPoint(int[] arr){
        int start = 0;
        int end = arr.length-1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(arr[mid] < mid){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        if(start < arr.length && arr[start] == start){
            return start;
        }
        return -1;
    }

    // 540. Single Element in a Sorted Array
    //You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.
    //
    //Return the single element that appears only once.
    //
    //Your solution must run in O(log n) time and O(1) space.
    public int singleNonDuplicate(int[] nums) {
        // even-odd..unpaired...odd-even
        if(nums.length == 1 || nums[0] != nums[1]){
            return nums[0];
        }
        if(nums[nums.length-1] != nums[nums.length-2]){
            return nums[nums.length-1];
        }
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(nums[mid] != nums[mid-1] &&  nums[mid] != nums[mid+1]){ // edge/boundary cases handled already
                return nums[mid];
            }
            if((mid % 2 == 0 && nums[mid] == nums[mid+1]) || (mid % 2 == 1 && nums[mid] == nums[mid-1])){
                start = mid + 1;
            }else{
                end = mid -1;
            }
        }
        return -1;
    }

    // 1228. Missing Number In Arithmetic Progression
    //In some array arr, the values were in arithmetic progression: the values arr[i + 1] - arr[i] are all equal for every 0 <= i < arr.length - 1.
    //
    //A value from arr was removed that was not the first or last value in the array.
    //
    //Given arr, return the removed value.
    public int missingNumber(int[] arr) {
        return 0;
    }

    //1060. Missing Element in Sorted Array
    //Given an integer array nums which is sorted in ascending order and all of its elements are unique and given also an integer k, return the kth missing number starting from the leftmost number of the array.
    public int missingElement(int[] nums, int k) {
        // <k...+k...>k
        int start = 0;
        int end = nums.length-1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(nums[mid] - (nums[0] + mid) < k){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        int missingOnLeft = nums[end] - (nums[0] + end);
        return nums[end] + k - missingOnLeft;
    }

    // 702. Search in a Sorted Array of Unknown Size
    //This is an interactive problem.
    //
    //You have a sorted array of unique elements and an unknown size. You do not have an access to the array but you can use the ArrayReader interface to access it. You can call ArrayReader.get(i) that:
    //
    //returns the value at the ith index (0-indexed) of the secret array (i.e., secret[i]), or
    //returns 231 - 1 if the i is out of the boundary of the array.
    //You are also given an integer target.
    //
    //Return the index k of the hidden array where secret[k] == target or return -1 otherwise.
    //
    //You must write an algorithm with O(log n) runtime complexity.
    /**
     * // This is ArrayReader's API interface.
     * // You should not implement it, or speculate about its implementation
     * interface ArrayReader {
     *     public int get(int index) {}
     * }
     */
    public int search(ArrayReader reader, int target) {
        return 0;
    }
}

interface ArrayReader{
    public int get(int index);
}
