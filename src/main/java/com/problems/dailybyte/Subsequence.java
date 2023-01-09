package com.problems.dailybyte;

/*
This question is asked by Google. Given two strings s and t return whether or not s is a subsequence of t.
Note: You may assume both s and t only consist of lowercase characters and both have a length of at least one.
 */
public class Subsequence {
    public boolean isSubsequence(String s, String t){
        if(s.length() > t.length()){
            return false;
        }
        int i =0;
        int j = 0;
        while(i < s.length() && j < t.length()){
            if(s.charAt(i) == t.charAt(j)){
                i++;
                //j++;
            }/*else{
                j++;
            }*/
            j++;
        }
        return i == s.length();
    }
}
