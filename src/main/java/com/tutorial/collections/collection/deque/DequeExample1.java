package com.tutorial.collections.collection.deque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class DequeExample1 {
    public static void main(String[] args) {
        // two implementations of the Dequeue interface
        Deque<String> deque = new ArrayDeque<>();
        Deque<String> deque1 = new LinkedList<>();

        // Queue mode
        deque.offerLast("Element 1");
        deque.offerLast("Element 2");

        String element1 = deque.pollFirst();
        String element2 = deque.pollFirst();
        System.out.println("Queue mode - element1 : " + element1 + ", element2 : " + element2);

        // Stack Mode
        deque.offerFirst("Element 1");
        deque.offerFirst("Element 2");

        String elem2 = deque.pollFirst();
        String elem1 = deque.pollFirst();
        System.out.println("Stack mode - elem2 :  " + elem2 + ", elem1 : " + elem1);

        System.out.println("deque : " + deque);

        // add(), addLast(), addFirst(), offer(), offerLast(), offerFirst()
        deque.add("elem1"); // adds to the end of the deque, same as addLast()
        deque.addLast("elem2");
        deque.addFirst("elem3");
        deque.offer("elem4"); // adds to the end of the deque, same as offerLast()
        deque.offerLast("elem5");
        deque.offerFirst("elem6");
        System.out.println("deque : " + deque);

        // push()
        deque.push("elem7"); // adds at the beginning of the deque, works like addFirst()
        System.out.println("deque : " + deque);

        // peek(), peekFirst(), peekLast() -  return null if deque is empty
        System.out.println("deque.peek() : " + deque.peek());
        System.out.println("deque.peekFirst() : " + deque.peekFirst());
        System.out.println("deque.peekLast() : " + deque.peekLast());
        System.out.println("deque : " + deque);

        // getFirst(), getLast() -  will throw exception if deque is empty
        System.out.println("deque.getFirst() : " + deque.getFirst());
        System.out.println("deque.getLast() : " + deque.getLast());
        System.out.println("deque : " + deque);

    }

}
