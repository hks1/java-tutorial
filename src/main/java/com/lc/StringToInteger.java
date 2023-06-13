package com.lc;

import java.util.Arrays;

public class StringToInteger {
    //https://leetcode.com/problems/string-to-integer-atoi/

    public int myAtoi(String s) {
        char[] arr = s.toCharArray();
        int result = 0;
        int negative = 1;;
        int index = 0;
        while(arr[index] == ' '){
            index++;
        }
        if(arr[index] == '-'){
            negative = -negative;
            index++;
        } else{
            if(arr[index] == '+'){
                index++;
            }
        }
        int power = 0;
        while(index < s.length() && Character.isDigit(arr[index]) ){
            if(result * negative > Integer.MAX_VALUE/10 ||
                    (result * negative == Integer.MAX_VALUE/10 && Integer.parseInt(String.valueOf(arr[index])) > 7)){
                return Integer.MAX_VALUE;
            }
            if(result * negative < Integer.MIN_VALUE/10 ||
                    (result * negative == Integer.MIN_VALUE/10 && Integer.parseInt(String.valueOf(arr[index])) > 8)){
                return Integer.MIN_VALUE;
            }
            result = result * 10 + Integer.parseInt(String.valueOf(arr[index])) ;
            index++;
        }
        return result * negative;
    }
}
