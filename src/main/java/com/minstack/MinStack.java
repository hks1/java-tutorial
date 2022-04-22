package com.minstack;

import java.util.Stack;

public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> min;
    public MinStack(){
        stack = new Stack<>();
        min = new Stack<>();
    }
    public void push(int val){
        if(min.size() == 0 || min.peek() >= val){
            min.push(val);
        }
        stack.push(val);
    }
    public void pop(){
        int val = stack.pop();
        if(min.size() > 0 && min.peek() == val){
            min.pop();
        }
        //stack.pop();
    }
    public int top(){
        if(stack.size() == 0){
            return -1;
        }
        return stack.peek();
    }
    public int getMin(){
        if(min.size() == 0){
            return -1;
        }
        return min.peek();
    }

    @Override
    public String toString() {
        return "MinStack{" +
                "stack=" + stack +
                ", min=" + min +
                '}';
    }
}

class TDMinStack{
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        System.out.println(minStack);
        minStack.pop();
        System.out.println(minStack);

        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack);

        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack);

        System.out.println(minStack.getMin());
        System.out.println(minStack);

    }
}
