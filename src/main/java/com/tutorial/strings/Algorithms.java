package com.tutorial.strings;

public class Algorithms {

    public String reverseWords(String s){
        if(s == null || s.trim().isEmpty()){
            return s;
        }
        String[] sentence = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word :
                sentence) {
            sb.append(reverse(word));
            sb.append(' ');
        }
        return sb.toString().trim();
    }

    public String reverse(String word){
        StringBuilder sb = new StringBuilder(word);
        return sb.reverse().toString();
    }
}

