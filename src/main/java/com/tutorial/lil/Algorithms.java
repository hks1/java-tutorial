package com.tutorial.lil;

//import org.junit.jupiter.api.Assertions;

class Data{
    public int return5(){
        return 5;
    }

    public boolean isUpperCaseString(String s){
        return s.chars()
                .allMatch(Character::isUpperCase);
    }

    public boolean isLowerCaseString(String s){
        return s.chars()
                .noneMatch(Character::isUpperCase);
    }

    public boolean isPasswordComplex(String s){
        return s.chars().anyMatch(Character::isUpperCase) &&
                s.chars().anyMatch(Character::isLowerCase) &&
                s.chars().anyMatch(Character::isDigit);
    }
}

public class Algorithms {

    public boolean searchSubstring(String s, String pattern){
        if(s == null || s.isEmpty()){
            return false;
        }
        for (int i = 0; i < s.length() - pattern.length() + 1; i++) {
            for (int j = 0; j < pattern.length(); j++) {
                if(s.charAt(i+j) != pattern.charAt(j)){
                    break;
                }
                if(j == pattern.length()-1){
                    System.out.println("string: " + s + ", pattern: " + pattern + ", starting index: " + i);
                    return true;
                }
            }
        }
        return false;
    }

    public String normalizeString(String s){
        /*String lowerCased = s.toLowerCase();
        String trimmed = lowerCased.trim();
        String normalized = trimmed.replace(",", "");*/
        return s.toLowerCase().trim().replace(",", "");
        //return normalized;
    }

    public String reversed(String s){
        if(s == null || s.isEmpty()){
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = s.length()-1; i >= 0 ; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public String reverse2(String s){
        if(s == null || s.isEmpty()){
            return s;
        }
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }



    public static void main(String[] args) {

        var data = new Data();
        //Assertions.assertEquals(5, data.return5());

        System.out.println(data.isPasswordComplex("Hell0"));
        System.out.println(data.isPasswordComplex("Hello"));
        System.out.println(data.isPasswordComplex("hello"));
        System.out.println(data.isPasswordComplex("HELLO"));
        System.out.println(data.isPasswordComplex("hell0"));
        System.out.println(data.isPasswordComplex("HELL0"));

        var obj = new Algorithms();
        System.out.println(obj.normalizeString("baSeBa,ll"));
        System.out.println(obj.normalizeString("   HellO There, BUDDY,"));

        System.out.println(obj.searchSubstring( "hello string", "hell"));
        System.out.println(obj.searchSubstring("hello string", "ing"));
        System.out.println(obj.searchSubstring("hello string", "unknown"));
        System.out.println(obj.searchSubstring("hello string", ""));
        System.out.println(obj.searchSubstring("", "unknown"));

        String var = "test";
        var.indexOf('c');
    }
}
