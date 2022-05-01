package com.problems.dailybyte;

// Day 4
// Given a string, return whether or not it uses capitalization correctly. A string correctly uses capitalization if all letters are capitalized, no letters are capitalized, or only the first letter is capitalized.
//
//Ex: Given the following strings...
//
//"USA", return true
//"Calvin", return true
//"compUter", return false
//"coding", return true

public class CorrectCapitalization {
    public boolean correctCapitalization(String str){
        if(str.length() == 1) {
            return true;
        }
        boolean upperCaseValid = true;
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(Character.isLowerCase(c)){
                if(upperCaseValid && i > 1){
                    return false;
                }
                upperCaseValid = false;
            }
            if(Character.isUpperCase(c) && !upperCaseValid){
                return false;
            }
        }
        return true;
    }
}
