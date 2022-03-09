package com.tutorial.collections.collection.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample1 {
    public static void main(String[] args) {
        Queue<Customer> queue = new LinkedList<>();

        queue.add(new Customer("Anna"));
        queue.add(new Customer("Marie"));
        queue.add(new Customer("Jane"));

        Customer anna = queue.poll();
        Customer marie = queue.poll();

        System.out.println("anna : " + anna.getName());
        System.out.println("marie : " + marie.getName());

        // add() vs offer()
            // add() - throw an exception is queue is full
            // offer() - return false if queue is full
        queue.add(new Customer("Mr. Add"));
        queue.offer(new Customer("Mr. Offer"));

        // poll() vs remove()
            // poll() - returns null if queue is empty
            // remove() - throws exception is queue is empty
        Customer customer1 = queue.poll();
        System.out.println(customer1.getName());
        Customer customer2 = queue.remove();
        System.out.println(customer2.getName());

        // peek(), size(),
        System.out.println("queue.size() : " + queue.size());
        Customer firstCustomer = queue.peek();
        System.out.println("queue.peek() : " + firstCustomer.getName());
        System.out.println("queue.size() : " + queue.size());
        queue.clear();
        System.out.println("queue.size() after queue.clear() : " + queue.size());


        //queue.add(new Customer("Anna"));
        queue.add(anna);
        queue.add(new Customer("Marie"));
        queue.add(new Customer("Jane"));

        // contains()
        //System.out.println(queue.contains(new Customer("Anna")));  // Doesn't work
        System.out.println(queue.contains(anna));

        // clear()
        queue.clear();
    }
}
