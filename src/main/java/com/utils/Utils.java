package com.utils;

import java.lang.reflect.Array;
import java.util.Arrays;

public final class Utils {

    public boolean isPalindrome(String s){
        int start = 0;
        int end = s.length();
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static String toBase64(int num){
        char[] base64 = new char[64];
        int index = 0;
        char chr = 'A';
        for(int i = 0 ; i < 26; i++){
            //base64[index++] = (char) (i + (int) 'A');
            base64[index++] = (char) (chr + i);
        }
        chr = 'a';
        for(int i = 0 ; i < 26; i++){
            //base64[index++] = (char) (i + (int) 'a');
            base64[index++] = (char) (chr + i);
        }
        chr = '0';
        for(int i = 0 ; i < 10; i++){
            //base64[index++] = (char) (i + (int) '0');
            base64[index++] = (char) (chr + i);
        }
        System.out.println(Arrays.toString(base64));
        StringBuilder sb = new StringBuilder();
        while(num > 0){
            sb.append(base64[num % 64]);
            num /= 64;
        }
        return sb.toString();
    }

    public static void swap(int[] arr, int i, int j){
        if(i == j) return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}

class TDUtils{
    public static void main(String[] args) {
        System.out.println(Utils.toBase64(123456789));
    }
}