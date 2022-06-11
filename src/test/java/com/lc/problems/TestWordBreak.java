package com.lc.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TestWordBreak {
    WordBreak obj;
    @BeforeEach
    public void setUP(){
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
        Assertions.assertTrue(obj.wordBreak("leetcode", Arrays.asList("leet", "code")));
        //new String[]{"leet", "code"}
        Assertions.assertTrue(obj.wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        Assertions.assertFalse(obj.wordBreak("catsandog", Arrays.asList("cats","dog","sand","and","cat")));

        Assertions.assertTrue(obj.wordBreakBFS("leetcode", Arrays.asList("leet", "code")));
        Assertions.assertTrue(obj.wordBreakBFS("applepenapple", Arrays.asList("apple", "pen")));
        Assertions.assertFalse(obj.wordBreakBFS("catsandog", Arrays.asList("cats","dog","sand","and","cat")));

        Assertions.assertTrue(obj.wordBreakDP("leetcode", Arrays.asList("leet", "code")));
        Assertions.assertTrue(obj.wordBreakDP("applepenapple", Arrays.asList("apple", "pen")));
        Assertions.assertFalse(obj.wordBreakDP("catsandog", Arrays.asList("cats","dog","sand","and","cat")));
    }
}
