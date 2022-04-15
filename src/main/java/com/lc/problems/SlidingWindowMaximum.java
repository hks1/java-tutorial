package com.lc.problems;

import java.util.ArrayDeque;
import java.util.Deque;

// LC 239
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k){
        int[] result = new int[nums.length - k + 1];
        int index = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i < k; i++){
            while(!deque.isEmpty() && nums[i] > deque.peekLast())
                deque.removeLast();
            deque.addLast(nums[i]);
        }
        result[index++] = deque.peekFirst();
        for(int i = k; i < nums.length; i++){
            if(deque.peekFirst() == nums[i - k])
                deque.removeFirst();
            while(!deque.isEmpty() && nums[i] > deque.peekLast())
                deque.removeLast();
            deque.addLast(nums[i]);
            result[index++] = deque.peekFirst();
        }
        return result;
    }
}
