package com.tutorial.collections.collection.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackExample3 {
    public static void main(String[] args) {

        // Stack and Deque - search doesn't work with Deque
        //Stack<String> stack = new Stack<>();
        Deque<String> stack = new ArrayDeque<>();

        stack.push("one");
        stack.push("two");

        System.out.println("stack.pop() : " + stack.pop());
        System.out.println("stack.peek() : " + stack.peek());
        //System.out.println("stack.search(\"one\") " + stack.search("one"));
    }
}
