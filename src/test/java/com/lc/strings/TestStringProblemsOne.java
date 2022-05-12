package com.lc.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestStringProblemsOne {
    StringProblemsOne obj;
    @BeforeEach
    public void setUp(){
        obj = new StringProblemsOne();
    }
    @Test
    public void testStrStr(){
        //Example 1:
        //
        //Input: haystack = "hello", needle = "ll"
        //Output: 2
        //Example 2:
        //
        //Input: haystack = "aaaaa", needle = "bba"
        //Output: -1
        Assertions.assertEquals(2, obj.strSStr("hello", "ll"));
        Assertions.assertEquals(-1, obj.strSStr("aaaaa", "bba"));
    }
    @Test
    public void testLongestPalindrome(){
        //Example 1:
        //
        //Input: s = "babad"
        //Output: "bab"
        //Explanation: "aba" is also a valid answer.
        //Example 2:
        //
        //Input: s = "cbbd"
        //Output: "bb"
        Assertions.assertEquals("bab", obj.longestPalindrome("babad"));
        Assertions.assertEquals("bb", obj.longestPalindrome("cbbd"));
    }
}
