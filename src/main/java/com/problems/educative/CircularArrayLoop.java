package com.problems.educative;

import java.util.Arrays;

public class CircularArrayLoop {

    public boolean circularArrayLoop(int [] nums){
        int size = nums.length;
        // iterate through each index of the array 'nums'.
        for (int i = 0; i < size - 1; i++) {
            // set slow and fast pointers at the current index value
            int slow = i, fast = i;
            // set 'forward' to true if element is +ve, set false otherwise
            boolean forward = nums[i] > 0;

            while (true){
                // move slow pointer by on step.
                slow = nextStep(slow, nums[slow], size);
                // if cycle is not possible, break the loop and start from next element
                if(isNotCycle(nums, forward, slow))
                    break;
                // first move of fast pointer
                fast = nextStep(fast, nums[fast], size);
                // if cycle not possible, break the loop and start from next element
                if(isNotCycle(nums, forward, fast))
                    break;

                // second move of fast pointer
                fast = nextStep(fast, nums[fast], size);
                // if cycle not possible, break the loop and start from next element
                if(isNotCycle(nums, forward, fast))
                    break;

                // at any point, if fast and slow pointers meet each other,
                // it indicates that loop has been found, return true.
                if (slow == fast)
                    return true;
            }
        }
        return false;
    }
    // function to calculate the next step
    private int nextStep(int pointer, int value, int size){
        int result = (pointer + value) % size;
        if(result < 0) result += size;
        return result;
    }
    // function to detect a cycle doesn't exist
    public boolean isNotCycle(int[] nums, boolean prevDirection, int pointer){
        // set curretn direction to true if current element is +ve, set false otherwise
        boolean currDirection = nums[pointer] >= 0;

        // if curretn direction and previous direction are different or moving a pointer takes back to the same value,
        // then cycle is not possible, we return true, otherwise return false.
        if (prevDirection != currDirection || Math.abs(nums[pointer] % nums.length) == 0){
            return true;
        }
        return  false;
    }

    public static void main(String[] args) {
        int[][] input = {
                {-2, -3, -9},
                {-5, -4, -3, -2, -1},
                {-1, -2, -3, -4, -5},
                {2, 1, -1, -2},
                {-1, -2, -3, -4, -5, 6},
                {1, 2, -3, 3, 4, 7, 1},
                {2, 2, 2, 7, 2, -1, 2, -1, -1}
        };
        CircularArrayLoop obj = new CircularArrayLoop();

        for (int i = 0; i < input.length; i++) {
            System.out.println((i + 1) + ".\tCircular array = " + Arrays.toString(input[i]) + "\n");
            boolean result = obj.circularArrayLoop(input[i]);
            System.out.println("\tFound Loop = " + result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
