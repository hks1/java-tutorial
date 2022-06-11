package com.lc.problems;

import com.lc.problems.LongestCommonSubsequence;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestLongestCommonSubsequence {
    LongestCommonSubsequence obj;
    @BeforeEach
    public void setUp(){
        obj = new LongestCommonSubsequence();
    }
    @Test
    public void testLongestCommonSubsequence(){
        //Example 1:
        //
        //Input: text1 = "abcde", text2 = "ace"
        //Output: 3
        //Explanation: The longest common subsequence is "ace" and its length is 3.
        //Example 2:
        //
        //Input: text1 = "abc", text2 = "abc"
        //Output: 3
        //Explanation: The longest common subsequence is "abc" and its length is 3.
        //Example 3:
        //
        //Input: text1 = "abc", text2 = "def"
        //Output: 0
        //Explanation: There is no such common subsequence, so the result is 0.
        Assertions.assertEquals(3, obj.longestCommonSubsequence("abcde", "ace"));
        Assertions.assertEquals(3, obj.longestCommonSubsequence("abc", "abc"));
        Assertions.assertEquals(0, obj.longestCommonSubsequence("abc", "def"));

        Assertions.assertEquals(3, obj.lcsbf("abcde", "ace"));
        Assertions.assertEquals(3, obj.lcsbf("abc", "abc"));
        Assertions.assertEquals(0, obj.lcsbf("abc", "def"));
    }
}
