package com.problems;

public class TowerOfHanoi {
    int i = 1;
    public void move(int n, String source, String dest, String helper){
        // base
        if(n == 1){
            System.out.println(i++ + " " + source + " -> " + dest);
            return;
        }
        // hypothesis
        move(n-1, source, helper, dest);
        // induction
        System.out.println(i++ + " " + source + " -> " + dest);
        move(n-1, helper, dest, source);
    }
}
