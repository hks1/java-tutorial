package com.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthlargestElement {
    public static void main(String[] args) {
        Integer[] arr = new Integer[] {4,5,2,9,1,7,11,19,12,78,15};
        int initialCApacity = 11;
        PriorityQueue<Integer> pq = new PriorityQueue<>(initialCApacity, new Comparator<Integer>() {
            public int compare(Integer n1, Integer n2){
                return n2 - n1;
            }
        });
        pq.addAll(Arrays.asList(arr));
        //System.out.println(pq.remove());
        int value = 0;
        for (int i = 0; i < 5; i++) {
            value = pq.remove();
        }
        System.out.println("5th largest value is : " + value);
    }
}
