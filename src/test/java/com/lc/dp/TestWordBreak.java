package com.lc.dp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestWordBreak {
    WordBreak obj;
    @BeforeEach
    public void setUp(){
        obj = new WordBreak();
    }
    @Test
    public void testWordBreak(){
        //Example 1:
        //
        //Input: s = "leetcode", wordDict = ["leet","code"]
        //Output: true
        //Explanation: Return true because "leetcode" can be segmented as "leet code".
        //Example 2:
        //
        //Input: s = "applepenapple", wordDict = ["apple","pen"]
        //Output: true
        //Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
        //Note that you are allowed to reuse a dictionary word.
        //Example 3:
        //
        //Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
        //Output: false
    }
}
