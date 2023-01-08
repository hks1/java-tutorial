package com.lc.problems;

// 225. Implement Stack using Queues

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues<T> {
    Queue<T> in;
    Queue<T> out;

    public StackUsingQueues(){
        in = new LinkedList<>();
        out = new LinkedList<>();
    }

    public void push(T t){
        in.offer(t);
        while(!out.isEmpty()){
            in.offer(out.poll());
        }
        Queue<T> temp = in;
        in = out;
        out = temp;
    }

    public T pop(){
        return out.poll();
    }

    public T peek(){
        return out.peek();
    }

    public boolean isEmpty(){
        return out.isEmpty();
    }

    @Override
    public String toString() {
        return "StackUsingQueues{" +
                "in=" + in +
                ", out=" + out +
                '}';
    }
}

class TDStackUsingQueues{
    public static void main(String[] args) {
        StackUsingQueues<Integer> q =  new StackUsingQueues<>();

        for (int i = 0; i < 5; i++) {
            q.push(i);
        }
        System.out.println(q);
        System.out.println(q.pop());
        q.push(5);
        System.out.println(q.pop());
        for (int i = 0; i < 10; i++) {
            q.push(i);
        }
        System.out.println(q.pop() + " " + q);
    }
}
