package com.strings;

import java.util.Arrays;

public class BoyerMoore {
    private int[] lastOccurences;

    public BoyerMoore(){
        lastOccurences = new int[256];
    }
    private void preprocessPattern(char[] pattern){
        Arrays.fill(lastOccurences, -1);
        for (int i = 0; i < pattern.length; i++) {
            //System.out.println(i + " " + (int)pattern[i]);
            //int c = pattern[i];
            //System.out.println(c);
            //System.out.println(i + " " + pattern[i] + " " + Integer.parseInt(String.valueOf(pattern[i])));
            lastOccurences[pattern[i]] = i;
        }
        //System.out.println(Arrays.toString(lastOccurences));
        //System.out.println(Arrays.toString(pattern));
    }

    public int search(String text, String pattern){
        return search(text.toCharArray(), pattern.toCharArray());
    }
    public int search(char[] text, char[] pattern){
        int textLength = text.length;
        int patternLength = pattern.length;

        preprocessPattern(pattern);

        int shift = 0;
        while(shift <= textLength- patternLength){
            int j = patternLength - 1;

            while (j >= 0 && pattern[j] == text[shift + j]){
                j--;
            }
            if(j < 0){
                return shift;
            }else{
                int last = lastOccurences[text[shift + j]];
                shift += Math.max(1, j - last);
            }
        }

        return -1;

    }
}

class BMTD{
    public static void main(String[] args) {
        //BoyerMoore obj = new BoyerMoore();
        BoyerMoore boyerMoore = new BoyerMoore();
        char[] text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.".toCharArray();
        char[] pattern = "ipsumi".toCharArray();

        int index = boyerMoore.search(text, pattern);

        String str1 = "abc";
        String str2 = "abc";

        System.out.println(str1 == str2);

        System.out.println(System.identityHashCode(str1));
        System.out.println(System.identityHashCode(str2));

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        System.out.println(System.identityHashCode(sb1) + " " + System.identityHashCode(sb2));

        char data[] = {'a', 'b', 'c'};
        String str = new String(data);

        System.out.println(str1 == str);
        String str3 = new String("abc");
        String str4  = new String("abc");

        print(str3);
        print(str4);
        print(str);

        System.out.println("abc".substring(2,3));


    }
    /*
    print System.identityHashCode() of the String str
     */
    public static void print(String str){
        System.out.println(System.identityHashCode(str));
    }
}
