package com.lc.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestStringPatternsOne {
    StringPatternsOne obj;
    @BeforeEach
    public void setUp(){
        obj = new StringPatternsOne();
    }
    @Test
    public void testIsValid(){
        //Example 1:
        //
        //Input: s = "()"
        //Output: true
        //Example 2:
        //
        //Input: s = "()[]{}"
        //Output: true
        //Example 3:
        //
        //Input: s = "(]"
        //Output: false
        Assertions.assertTrue(obj.isValid("()"));
        Assertions.assertTrue(obj.isValid("()[]{}"));
        Assertions.assertFalse(obj.isValid("(]"));
    }
    @Test
    public void testGenerateParenthesis(){
        //Example 1:
        //
        //Input: n = 3
        //Output: ["((()))","(()())","(())()","()(())","()()()"]
        //Example 2:
        //
        //Input: n = 1
        //Output: ["()"]
    }
}
