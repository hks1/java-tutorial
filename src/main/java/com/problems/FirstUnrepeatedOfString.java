package com.problems;

public class FirstUnrepeatedOfString {
    public char firstUnrepeated(String s){
        char result = '\0';
        int[] counts = new int[26];
        for(int i = s.length()-1; i >= 0; i--){
            counts[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if(counts[s.charAt(i) - 'a'] == 1){
                return s.charAt(i);
            }
        }
        return result;
    }
}
