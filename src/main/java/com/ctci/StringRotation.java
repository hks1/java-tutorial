package com.ctci;

/**
 * 1.9
 */
public class StringRotation {
    public boolean stringRotation(String s1, String s2){
        return (s2+s2).contains(s1);
    }
}
