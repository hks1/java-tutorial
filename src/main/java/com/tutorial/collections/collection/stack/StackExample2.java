package com.tutorial.collections.collection.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StackExample2 {
    public static void main(String[] args) {
        // Reverse elements of a Java List using Java Stack
        Stack<String> stack = new Stack<>();
        List<String> list = new ArrayList<>();

        list.add("1");
        list.add("2");
        list.add("3");

        System.out.println("list is : " + list);

        //while (!list.isEmpty()){
        while (list.size() > 0){
            stack.push(list.remove(0));
        }

        System.out.println("stack : " + stack);

        //while(!stack.empty()){
        while(stack.size() > 0){
            list.add(stack.pop());
        }

        System.out.println("reverse list : " + list);
    }
}
