package com.tutorial.collections.collection.stack;

import java.util.Iterator;
import java.util.Stack;

public class StackExample1 {
    public static void main(String[] args) {
        // Stack class is synchronized - causes some performance overhead
        // use Java Deque to avoid the overhead
        Stack stack = new Stack();

        // push(), pop()
        stack.push("one");
        stack.push("two");
        stack.push("three");
        System.out.println("stack : " + stack);

        System.out.println("stack.pop() : " + stack.pop());
        System.out.println("stack.pop() : " + stack.pop());
        System.out.println("stack : " + stack);

        // peek()
        System.out.println("stack.peek() : " + stack.peek());
        System.out.println("stack : " + stack);

        // search() -  returns -1 if element not found
        System.out.println("stack.search(\"one\") : " + stack.search("one"));

        stack.push("four");
        System.out.println("stack : " + stack);
        System.out.println("stack.search(\"one\") : " + stack.search("one"));
        System.out.println("stack.search(\"two\") : " + stack.search("two"));

        // Iterate
        Iterator iterator = stack.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        for (Object element :
                stack) {
            System.out.println(element);
        }

        stack.stream().forEach((element) -> System.out.println(element));


        /*String two = (String) stack.pop();
        String one = (String) stack.pop();

        System.out.println(two);
        System.out.println(one);*/
    }
}
