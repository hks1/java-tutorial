package com.problems.dailybyte;

// You are given two strings, s and t which only consist of lowercase letters. t is generated by shuffling the letters in s as well as potentially adding an additional random character. Return the letter that was randomly added to t if it exists, otherwise, return ’  ‘.
//Note: You may assume that at most one additional character can be added to t.
//
//Ex: Given the following strings...
//
//s = "foobar", t = "barfoot", return 't'
//s = "ide", t = "idea", return 'a'
//s = "coding", t "ingcod", return ''

import java.util.HashMap;
import java.util.Map;

public class SpotTheDifference {
    public Character spotTheDifference(String s, String t){
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for(int i = 0; i < t.length(); i++){
            if(map.containsKey(t.charAt(i))){
                map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
                if(map.get(t.charAt(i)) == 0){
                    map.remove(t.charAt(i));
                }
            }else{
                return t.charAt(i);
            }
        }
        return '\0';
    }
}

class TDSpotTheDifference{
    public static void main(String[] args) {
        SpotTheDifference obj = new SpotTheDifference();
        System.out.println(obj.spotTheDifference("coding", "ingcod"));
    }
}
