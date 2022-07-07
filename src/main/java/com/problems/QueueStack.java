package com.problems;

import java.util.LinkedList;
import java.util.Queue;

public class QueueStack {
    //Design a class to implement a stack using only a single queue.
    // Your class, QueueStack, should support the following stack methods:
    //  push() (adding an item),
    //  pop() (removing an item),
    //  peek() (returning the top value without removing it), and
    //  empty() (whether or not the stack is empty).

    Queue<Integer> stack;

    public QueueStack(){
         stack = new LinkedList<>();
    }
    public void push(int val){
        stack.offer(val);
    }
    public int pop(){
        return 0;
    }
    public int peek(){
        return 0;
    }
    public boolean empty(){
        return stack.isEmpty();
    }
}
