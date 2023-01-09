package com.problems.dailybyte;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
Ex: Given the following strings s and t…

s = "abc", t = "aabbcc", return true.
Ex: Given the following strings s and t…

s = "cpu", t = "computer", return true.
Ex: Given the following strings s and t…

s = "xyz", t = "axbyc", return false.
 */
public class TestSubsequence {
    Subsequence obj;
    @BeforeEach
    public void setUp(){
        obj = new Subsequence();
    }
    @Test
    public void testIsSubsequence(){
        Assertions.assertEquals(true, obj.isSubsequence("abc", "aabbcc"));
        Assertions.assertEquals(true, obj.isSubsequence("cpu", "computer"));
        Assertions.assertEquals(false, obj.isSubsequence("xyz", "axbyc"));
    }
}
