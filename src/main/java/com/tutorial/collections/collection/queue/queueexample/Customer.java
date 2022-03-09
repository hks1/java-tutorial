package com.tutorial.collections.collection.queue.queueexample;

public class Customer {

    private boolean hasBeenServed;
    String name;

    public Customer(String name){
        hasBeenServed = false;
        this.name = name;
    }

    public void serve(){
        hasBeenServed = true;
        System.out.println(name + " has been served.");
    }

    /*@Override
    public String toString() {
        return "Customer{" +
                "hasBeenServed=" + hasBeenServed +
                ", name='" + name + '\'' +
                '}';
    }*/

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                '}';
    }
}
