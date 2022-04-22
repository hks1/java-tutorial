package com.problems;

import java.util.Stack;

public class SortAStack {
    // sort a stack recursively
    public Stack<Integer> sort(Stack<Integer> stack){
        // base case
        if(stack.size() <= 1) return stack;
        // recursive - hypothesis
        int elem = stack.pop();
        sort(stack);
        // induction
        insert(stack, elem);
        return stack;
    }
    public void insert(Stack<Integer> stack, int val){
        // base
        if(stack.size() == 0 || stack.peek() <= val) stack.push(val);
        else{
            // recursion - hypothesis
            int temp = stack.pop();
            insert(stack, val);
            // induction
            stack.push(temp);
        }
    }
}
