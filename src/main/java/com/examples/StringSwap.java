package com.examples;

public class StringSwap {
    public static void main(String[] args) {
        String temp1 = "ABC1";
        String temp2 = "ABC2";
        swap(temp2, temp1);
        System.out.println(temp1 + " " + temp2);
    }

    public static void swap(String temp1, String temp2){
        String temp = temp1;
        temp1 = temp2;
        temp2 = temp;
    }
}
