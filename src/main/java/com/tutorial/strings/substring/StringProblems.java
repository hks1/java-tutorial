package com.tutorial.strings.substring;

import java.util.HashSet;
import java.util.Set;

public class StringProblems {
    public int shortestControllingSet(String s, Set<Character> controllingSet){
        int minLength = Integer.MAX_VALUE;
        for(int i = 0; i < s.length(); i++){
            StringBuilder sb = new StringBuilder();

            for(int j = i; j < s.length(); j++){
                sb.append(s.charAt(j));
                if(isControllingSet(sb.toString(), controllingSet)){
                    //minLength = Math.min(minLength, sb.length());
                    minLength = Math.min(minLength, j - i + 1);
                }
            }
        }
        return minLength;
    }

    public boolean isControllingSet(String s, Set<Character> cs){
        Set<Character> setCopy = new HashSet<>(cs);
        for(int i = 0; i < s.length(); i++){
            if(setCopy.contains(s.charAt(i))){
                setCopy.remove(s.charAt(i));
            }
            if(setCopy.size() == 0) return  true;
        }
        return false;
    }

    public int smallestNumberByRemovingKDigits(int num, int k){
        return 0;
    }
}
