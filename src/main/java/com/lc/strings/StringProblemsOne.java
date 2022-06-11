package com.lc.strings;

public class StringProblemsOne {
    //28. Implement strStr()
    //Implement strStr().
    //
    //Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
    //
    //Clarification:
    //
    //What should we return when needle is an empty string? This is a great question to ask during an interview.
    //
    //For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
    public int strSStr(String haystack, String needle){
        if(haystack == null || needle.length() > haystack.length()){
            return -1;
        }
        if(needle == null || needle.length() == 0){
            return 0;
        }
        for(int i = 0; i < haystack.length() - needle.length() + 1; i++){
            int j = 0;
            for (; j < needle.length(); j++) {
                if(haystack.charAt(i+j) != needle.charAt(j)){
                    break;
                }
            }
            if(j == needle.length()){
                return i;
            }
        }
        return -1;
    }

    //5. Longest Palindromic Substring
    //Given a string s, return the longest palindromic substring in s.
    public String longestPalindrome(String s) {
        return "";
    }
}
