package com.strings.substring;

public class SubstringMatch {
    public boolean matchSubstring(String str1, String str2){
        /*
        return true if str1 is a substring of str2
         */
        for(int i = 0; i < str2.length(); i++){
            int j = 0;
            for(; j < str1.length(); j++){
                if(str1.charAt(j) != str2.charAt(i + j)) break;
            }
            if(j == str1.length()) return true;
        }
        return false;
    }
}
