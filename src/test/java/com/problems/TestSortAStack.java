package com.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class TestSortAStack {
    SortAStack obj;
    Stack<Integer> stack;
    Stack<Integer> sortedStack;
    @BeforeEach
    public void setUp(){
        obj = new SortAStack();
        // initialize a stack
        stack = new Stack<>();
        for (int i = 0; i < 10; i = i + 2) {
            stack.push(i);
        }
        for (int i = 1; i < 10; i = i + 2) {
            stack.push(i);
        }
        sortedStack = new Stack<>();
        for (int i = 0; i < 10; i++) {
            sortedStack.push(i);
        }
    }
    @Test
    @DisplayName("test stack sort - recursive")
    public void testStackSortRecursive(){
        Assertions.assertEquals(sortedStack, obj.sort(stack));
    }
}
