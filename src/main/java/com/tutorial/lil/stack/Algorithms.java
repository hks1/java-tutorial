package com.tutorial.lil.stack;

import java.util.Stack;

public class Algorithms {
    public void printNextGreaterNumber(int[] arr){
        if(arr.length == 0){
            System.out.println();
            return;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        for(int i = 1; i < arr.length; i++){
            int next = arr[i];
            if(!stack.empty()){
                int popped = stack.pop();
                while (popped < next){
                    System.out.println(popped + " --> " + next);
                    if(stack.empty()){
                        break;
                    }
                    popped = stack.pop();
                }
                if(popped > next){
                    stack.push(popped);
                }
            }

            stack.push(next);
        }

        while (!stack.empty()){
            System.out.println(stack.pop() + " -- > " + -1);
        }
    }
}

class AlgoTD{
    public static void main(String[] args) {
        Algorithms obj = new Algorithms();
        int[] arr = {16, 7, 2, 15, 7, 8, 9};
        obj.printNextGreaterNumber(arr);
    }
}
