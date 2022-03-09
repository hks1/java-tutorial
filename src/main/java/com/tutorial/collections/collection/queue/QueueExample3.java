package com.tutorial.collections.collection.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample3 {
    public static void main(String[] args) {
        Queue queue = new LinkedList();
        queue.offer("John");

        System.out.println(queue.contains("John")); //  true
        System.out.println(queue.contains("Hannah"));  // false

        // Iterating
    }
}
