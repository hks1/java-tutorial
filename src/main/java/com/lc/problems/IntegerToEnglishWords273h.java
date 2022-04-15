package com.lc.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class IntegerToEnglishWords273h {
    Map<Integer, String> map = new HashMap<>();

     {
        map.put(10, "Ten");
        map.put(9, "Nine");
        map.put(8, "Eight");
        map.put(7, "Seven");
        map.put(6, "Six");
        map.put(5, "Five");
        map.put(4, "Four");
        map.put(3, "Three");
        map.put(2, "Two");
        map.put(1, "One");
         map.put(20, "Twenty");
         map.put(30, "Thirty");
         map.put(40, "Forty");
         map.put(50, "Fifty");
         map.put(60, "Sixty");
         map.put(70, "Seventy");
         map.put(80, "Eighty");
         map.put(90, "Ninety");
         map.put(11, "Eleven");
         map.put(12, "Twelve");
         map.put(13, "Thirteen");
         map.put(14, "Fourteen");
         map.put(15, "Fifteen");
         map.put(16, "Sixteen");
        map.put(17, "Seventeen");
        map.put(18, "Eighteen");
        map.put(19, "Nineteen");
     }

    public void initializeMap(){
        /*map.put(new Pair(1000000000, "Billion"));
        map.put(new Pair(1000000, "Million"));
        map.put(new Pair(1000, "Thousand"));
        map.put(new Pair(100, "Hundred"));
        map.put(new Pair(90, "Ninety"));
        map.put(new Pair(80, "Eighty"));

        map.put(new Pair(70, "Seventy"));
        map.put(new Pair(60, "Sixty"));
        map.put(new Pair(50, "Fifty"));
        map.put(new Pair(40, "Fourty"));

        map.put(new Pair(30, "Thirty"));
        map.put(new Pair(20, "Twenty"));
        map.put(new Pair(19, "Nineteen"));
        map.put(new Pair(18, "Eighteen"));
        map.put(new Pair(17, "Seventeen"));
        map.put(new Pair(16, "Sixteen"));
        map.put(new Pair(15, "Fifteen"));
        map.put(new Pair(14, "Fourteen"));
        map.put(new Pair(13, "Thirteen"));
        map.put(new Pair(12, "Twelve"));
        map.put(new Pair(11, "Eleven"));
        map.put(new Pair(10, "Ten"));
        map.put(new Pair(9, "Nine"));
        map.put(new Pair(8, "Eight"));
        map.put(new Pair(7, "Seven"));
        map.put(new Pair(6, "Six"));
        map.put(new Pair(5, "Five"));
        map.put(new Pair(4, "Four"));
        map.put(new Pair(3, "Three"));
        map.put(new Pair(2, "Two"));
        map.put(new Pair(1, "One"));*/
    }

    public String threeDigitsToName(int num){
        if( num == 0){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int hundreds = num/100;
        int tens = (num%100)/10;
        int ones = num%10;
        if(hundreds > 0){
            sb.append(map.get(hundreds));
            sb.append("Hundred");
        }
        if(tens == 1){
            sb.append(map.get(num%100));
            return sb.toString();
        }
        if(tens > 0){
            sb.append(map.get(tens*10));
        }
        if(ones > 0){
            sb.append(map.get(ones));
        }
        return sb.toString();
    }

    String[] suffix = {"Billion", "Million, Thousand", ""};

    public String numberToWords(int num){
        if(num == 0) return new String("zero");
         int q = 0;
         int denominator = 1000000000;
         StringBuilder sb = new StringBuilder();
        for (int i = 0; i < suffix.length; i++) {
            q = num/denominator;
            num = num % denominator;
            if(q > 0){
                System.out.println("q ->" + q);
                System.out.println(sb.toString());
                sb.append(threeDigitsToName(q));
                System.out.println(sb.toString());
                sb.append(suffix[i]);
                System.out.println(sb.toString());
            }
            denominator = denominator/1000;
        }
         return sb.toString();
    }

    public static void main(String[] args) {
         IntegerToEnglishWords273h obj = new IntegerToEnglishWords273h();
        System.out.println(obj.threeDigitsToName(123));
        System.out.println(obj.numberToWords(123456789));
    }
}
