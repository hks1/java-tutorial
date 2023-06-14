package com.utils;

import java.util.Arrays;
import java.util.List;

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

    public Integer[] listToArray(List<Integer> list){
        return list.toArray(new Integer[0]);
    }

    public int[] listToIntArray(List<Integer> list){
        return list.stream().mapToInt(i -> i).toArray();
    }

    /*public List<Integer> arrayToList(int[] arr){
        return Arrays.asList(arr);
    }*/

    public static String padRight(String s, int n) {
        return String.format("%-" + n + "s", s); //"%-20s"
    }

    public static String padLeft(String s, int n) {
        return String.format("%" + n + "s", s); //"%20s"
    }


    /**
     * @param n
     * @return sum of square of digits of n
     * Example: n = 14, return (1 * 1) + (4 * 4)
     */
    public static int sumOfSquaredDigits(int n){
        int sum = 0;
        while(n > 0){
            int rem = n % 10;
            n /= 10;
            sum += (rem * rem);
        }
        return sum;
    }


}

class TDUtils{
    public static void main(String[] args) {
        System.out.println(Utils.toBase64(123456789));

        System.out.println(Utils.padRight("Howto", 20) + "*");
        System.out.println(Utils.padLeft("Howto", 20) + "*");
    }
}
