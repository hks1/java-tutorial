package com.problems;

import java.util.Arrays;

public class CheckSumQuestionOne {
    //Given a string "5 7 8 9 \n 8 7 6 \n 4 5 6", differentiate rows from \n and find the largest and smallest number and return a sum of the largest and smallest numbers for each row. Return sum of all the numbers from each row.
    //Input: "5 7 8 9 \n 8 7 6 \n 4 5 6"
    //{14, 14, 10} - Return sum of all the numbers in an array
    //Output: 38
    public int findChecksum(String s){
        int sum = 0;
        String[] lines = s.split("\n");
        for(String line : lines){
            //char[] arr = line.split(" ");
            //System.out.println(Arrays.toString(line.toCharArray()));
            String[] arr = line.trim().split(" ");
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for(String val : arr){
                min  = Math.min(min, Integer.parseInt(String.valueOf(val)));
                max = Math.max(max, Integer.parseInt(String.valueOf(val)));
            }
            sum += min + max;
            System.out.println(Arrays.toString(arr));
        }
        return sum;
    }

    // another implementation
    public int checksum(String s){
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '\n'){
                sum += min + max;
                min = Integer.MAX_VALUE;
                max = Integer.MIN_VALUE;
            }
            if(Character.isDigit(s.charAt(i))){
                int val = Integer.parseInt(String.valueOf(s.charAt(i)));
                min = Math.min(min, val);
                max = Math.max(max, val);
            }
        }
        sum += min + max;
        return sum;
    }
}

class TDCheckSumQuestionOne{
    public static void main(String[] args) {
        CheckSumQuestionOne obj = new CheckSumQuestionOne();
        obj.findChecksum("5 7 8 9 \n 8 7 6 \n 4 5 6");
    }
}
