package com.problems.educative;

import java.util.*;

public class PalindromeII{
    public static boolean isPalindrome(String s) {
        // Write your code here
        // Tip: You may use the code template provided
        // in the TwoPointers.java file
        int start = 0;
        int end = s.length()-1;
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
               return isPalindrome(s, start+1, end) || isPalindrome(s, start, end-1);
            }else {
                start++;
                end--;
            }
        }


        return true;
    }

    public static boolean isPalindrome(String s, int start, int end){
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        //String s = "abcdedadedecba";
        String s = "dedadede";
        //System.out.println(String.valueOf(isPalindrome(s)));
        System.out.println(isPalindrome(s));
    }
}
