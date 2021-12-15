package com.tutorial.java.collections.collection.queue.queueexample;

import java.util.LinkedList;

public class Store {

    public static void main(String[] args) {
        LinkedList<Customer> queue = new LinkedList<>();
        queue.add(new Customer("Sally"));
        queue.add(new Customer("Beth"));
        queue.add(new Customer("Emma"));
        queue.add(new Customer("Jen"));
        System.out.println(queue);
        serverCustomer(queue);
        System.out.println(queue);
    }

    static void serverCustomer(LinkedList<Customer> queue){
        Customer c = queue.poll();
        c.serve();
    }
}
