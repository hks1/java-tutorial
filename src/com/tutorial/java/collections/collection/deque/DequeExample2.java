package com.tutorial.java.collections.collection.deque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DequeExample2 {
    public static void main(String[] args) {
        Deque<String> deque = new ArrayDeque<>();

        deque.add("elem1"); // adds to the end of the deque, same as addLast()
        deque.addLast("elem2");
        deque.addFirst("elem3");
        deque.offer("elem4"); // adds to the end of the deque, same as offerLast()
        deque.offerLast("elem5");
        deque.offerFirst("elem6");

        System.out.println(deque);

        // remove(), removeFirst(), removeLast() - throws exception if queue is empty
        System.out.println("deque.remove() : " + deque.remove());
        System.out.println("deque.removeFirst() : " + deque.removeFirst());
        System.out.println("deque.removeLast() : " + deque.removeLast());
        System.out.println("deque : " + deque);

        // poll(), pollFirst(), pollLast() - returns null if queue is empty
        System.out.println("deque.poll() : " + deque.poll());
        System.out.println("deque.pollFirst() : " + deque.pollFirst());
        System.out.println("deque.pollLast() : " + deque.pollLast());
        System.out.println("deque.pollLast() : " + deque.pollLast());
        //System.out.println("deque.removeLast() : " + deque.removeLast()); // NoSuchElementException
        System.out.println("deque : " + deque);

        // pop() -  throws exception is deque is empty
        deque.push("elem7");
        deque.push("elem8");
        System.out.println("deque : " + deque);
        System.out.println("deque.pop() : " + deque.pop());
        System.out.println("deque : " + deque);
        System.out.println("deque.pop() : " + deque.pop());
        try {
            System.out.println("deque.pop() : " + deque.pop()); // NoSuchElementException
        } catch (NoSuchElementException e){
            //e.printStackTrace();
            //System.err.println("deque is empty - pop() threw exception.");
            System.out.println("ERROR in pop()");
        }
        deque.push("elem7");
        deque.push("elem8");

        // contains(), size()
        System.out.println("deque.contains(\"elem7\") : " + deque.contains("elem7"));
        System.out.println("deque.contains(\"elem9\") : " + deque.contains("elem9"));
        System.out.println("deque.size() : " + deque.size());

        System.out.println("deque : " + deque);

        // Iterate

        Iterator iterator = deque.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        for (String elem :
                deque) {
            System.out.println(elem);
        }

        deque.stream().forEach((elem) -> System.out.println(elem));

    }
}
