package com.examples;

import java.util.Arrays;
import java.util.PriorityQueue;

public class TopK {

    public static void main(String[] args) {
        TopK obj = new TopK();
        int[] numbers = new int[]{4,6,8,3,7,5,9};
        int[] result = obj.getTopK(numbers, 3);
        System.out.println(Arrays.toString(result));
    }

    public int[] getTopK(int[] numbers, int k){
        int[] result = new int[k];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k+1);
        for (int i = 0; i < numbers.length; i++) {
            priorityQueue.add(numbers[i]);
            if(priorityQueue.size() > k){
                priorityQueue.remove();
            }
        }
        int index = 0;
        while (priorityQueue.size() > 0){
            result[index++] = priorityQueue.poll();
        }
        // reverse the result array

        return result;
    }
}
