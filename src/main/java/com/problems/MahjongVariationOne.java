package com.problems;

import java.util.HashMap;
import java.util.Map;

public class MahjongVariationOne {
    //https://leetcode.com/discuss/interview-question/1740425/indeed-phone-interview-mini-game
    public boolean complete(String tiles){
        Map<Integer, Integer> map = new HashMap<>();
        for(char c : tiles.toCharArray()){
            //int cValue = Integer.valueOf(c);
            int cValue = Integer.parseInt(String.valueOf(c));
            map.put(cValue, map.getOrDefault(cValue, 0) + 1);
        }
        System.out.println(map);
        int count = 0;
        for(int i : map.keySet()){
            // triples
            if(map.get(i)%3 == 1){
                return false;
            }
            if(map.get(i)%3 == 2){
                count++;
            }
        }
        return count == 1 ? true : false;
    }
}


