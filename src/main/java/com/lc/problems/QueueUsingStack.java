package com.lc.problems;

import java.util.Queue;
import java.util.Stack;

// 232. Implement Queue using Stacks

public class QueueUsingStack<T> {
    // in java implementations for Queue
    // poll() returns null
    // remove() returns NoSuchElementException

    Stack<T> s1;
    Stack<T> s2;
    int size;

    public QueueUsingStack(){
        s1 = new Stack<>();
        s2 = new Stack<>();
        size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void push(T t){
        s1.push(t);
        size++;
    }

    public T pop(){
        if(!s2.isEmpty()){
            size--;
            return s2.pop();
        }
        if(!s1.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            size--;
            return s2.pop();
        }
        return null;  // poll() behaviour
    }

    public T peek(){
        if(!s2.isEmpty()){
            return s2.peek();
        }
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        return s2.peek();
    }

    @Override
    public String toString() {
        return "QueueUsingStack{" +
                "s1=" + s1 +
                ", s2=" + s2 +
                ", size=" + size +
                '}';
    }
}

class TDQUsingStack{
    public static void main(String[] args) {
        QueueUsingStack<Integer> q = new QueueUsingStack<>();
        System.out.println(q.pop());
        for (int i = 0; i < 10; i++) {
            q.push(i);
        }
        System.out.println(q);
        System.out.println(q.pop() + " " + q);
        for (int i = 10; i < 15; i++) {
            q.push(i);
        }
        System.out.println(q.peek());
        System.out.println(q);
        for (int i = 0; i < 5; i++) {
            System.out.println(q.pop() + " " + q);
        }
    }
}
