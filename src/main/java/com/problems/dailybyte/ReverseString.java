package com.problems.dailybyte;

// Given a string, reverse all of its characters and return the resulting string.
//
//Ex: Given the following strings...
//
//“Cat”, return “taC”
//“The Daily Byte”, return "etyB yliaD ehT”
//“civic”, return “civic”

public class ReverseString {
    public String reverse(String str){
        StringBuilder sb = new StringBuilder();
        for(int i = str.length()-1; i >= 0; i--){
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}
