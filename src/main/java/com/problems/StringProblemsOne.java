package com.problems;

import java.util.*;

public class StringProblemsOne {
    // shortest substring of 's' that has all the characters from string 't'
    public String controlSet(String s, String t){
        // T(n) : o(n^2)
        int[] result = {-1, -1};
        int shortest = Integer.MAX_VALUE;
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < t.length(); i++){
            set.add(t.charAt(i));
        }
        int left = 0;
        for(int i = 0; i < s.length(); i++){
            Map<Character, Integer> map = new HashMap<>();

            for(int j = i; j < s.length(); j++){
                //System.out.println(s.substring(i, j+1));
                if(set.contains(s.charAt(j))){
                    map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
                }
                if(map.size() == set.size() && j - i + 1 < shortest){
                    //shortest = Math.min(shortest, j - i + 1);
                    shortest = j - i + 1;
                    result[0] = i;
                    result[1] = j+1;
                }
            }
        }
        return s.substring(result[0], result[1]);
    }

    public String controlSetSlidingWindow(String s, String t){
        // T(n) : O(n)
        int[] result = {-1, -1};
        int shortest = Integer.MAX_VALUE;
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < t.length(); i++){
            set.add(t.charAt(i));
        }
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(set.contains(s.charAt(i))){
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            }
            while (map.size() >= set.size()){
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                if(map.get(s.charAt(left)) == 0){
                    map.remove(s.charAt(left));
                }
                left++;
            }
            //left--;
            //map.put(s.charAt(left), map.getOrDefault(s.charAt(left), 0) + 1);
            if(map.size() == set.size() && i - left + 1 < shortest){
                shortest = i - left + 1;
                result[0] = left;
                result[1] = i;
            }
        }
        return s.substring(result[0], result[1]);
    }
}

class TDStringProblemsOne{
    public static void main(String[] args) {
        StringProblemsOne obj = new StringProblemsOne();
        System.out.println(obj.controlSet("helloworld", "lrw"));
        System.out.println(obj.controlSet("helloworwld", "lrw"));
        System.out.println(obj.controlSetSlidingWindow("helloworld", "lrw"));
        System.out.println(obj.controlSetSlidingWindow("helloworwld", "lrw"));
    }
}
