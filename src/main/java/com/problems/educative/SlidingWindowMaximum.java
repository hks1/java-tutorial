package com.problems.educative;

import java.util.*;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = new int[]{-4, 5, 4, -4, 4, 6, 7, 20};
        int k = 3; //windowSize

        int[] result = new int[nums.length - k + 1];

        Deque<Integer> deq = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            while(!deq.isEmpty() && deq.peekLast() < nums[i])
                deq.removeLast();
            deq.addLast(nums[i]);
        }
        int index = 0;
        result[index++] = deq.peekFirst();
        for (int i = k; i < nums.length; i++) {
            if(nums[i-k] == deq.peekFirst()){
                deq.removeFirst();
            }
            while (!deq.isEmpty() && deq.peekLast() < nums[i])
                deq.removeLast();
            deq.addLast(nums[i]);
            result[index++] = deq.peekFirst();
        }
        System.out.println(Arrays.toString(result));

    }
}

