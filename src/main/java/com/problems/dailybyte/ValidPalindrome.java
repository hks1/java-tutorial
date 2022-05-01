package com.problems.dailybyte;

// Day 2
// Given a string, return whether or not it forms a palindrome ignoring case and non-alphabetical characters.
//Note: a palindrome is a sequence of characters that reads the same forwards and backwards.
//
//Ex: Given the following strings...
//
//"level", return true
//"algorithm", return false
//"A man, a plan, a canal: Panama.", return true

public class ValidPalindrome {
    public boolean isValidPalindrome(String str){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            if(Character.isAlphabetic(str.charAt(i)))
            sb.append(Character.toLowerCase(str.charAt(i)));
        }
        //System.out.println(str + " " + sb.toString());
        for(int i = 0; i < sb.length()/2; i++){
            if(sb.charAt(i) != sb.charAt(sb.length()-1-i)){
                return false;
            }
        }
        return true;
    }
}
