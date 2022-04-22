package com.ctci;

import java.util.HashSet;
import java.util.Set;

public class IsUnique {
    /*public boolean isUnique(String str){
        for (int i = 0; i < str.length(); i++) {
            for (int j = i+1; j < str.length(); j++){
                if(str.charAt(i) == str.charAt(j)){
                    return false;
                }
            }
        }
        return true;
    }*/

    /*public boolean isUnique(String str){
        // can be done by Set, no need of Map
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            if(map.containsKey(str.charAt(i))){
                return false;
            }
            map.put(str.charAt(i), 1);
        }
        return true;
    }*/

    public boolean isUnique(String str){
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            if(set.contains(str.charAt(i))){
                return false;
            }
            set.add(str.charAt(i));
        }
        return true;
    }


}

class Main{
    public static void main(String[] args) {
        //String str = "A quick brown fox jumps over a lazy dog.";
        String str = "abcde";
        //System.out.println(str.charAt(0));
        IsUnique isUnique = new IsUnique();
        System.out.println(isUnique.isUnique(str));
    }
}