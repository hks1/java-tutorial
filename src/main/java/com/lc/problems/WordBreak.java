package com.lc.problems;

import java.util.*;

public class WordBreak {
    //139. Word Break
    //Medium
    //
    //10447
    //
    //460
    //
    //Add to List
    //
    //Share
    //Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
    //
    //Note that the same word in the dictionary may be reused multiple times in the segmentation.
    public boolean wordBreak(String s, List<String> wordDict) {
        return helper(s, 0, new HashSet<>(wordDict));
    }

    public boolean helper(String s, int start, Set<String> wordSet){
        // base case
        if(start == s.length()){
            return true;
        }
        // recursive
        for (int end = start+1; end <= s.length(); end++) {
            if(wordSet.contains(s.substring(start, end)) && helper(s, end, wordSet)){ // 'end' is exclusive in substring
                return true;
            }
        }
        return false;
    }

    // using BFS
    public boolean wordBreakBFS(String s, List<String> wordDict){
        Set<String> wordDictSet = new HashSet<>(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[s.length()];
        queue.add(0);
        while (!queue.isEmpty()){
            int start = queue.remove();
            if(visited[start]){
                continue;
            }
            for(int end = start + 1; end <= s.length(); end++){
                if(wordDictSet.contains(s.substring(start, end))){
                    queue.add(end);
                    if(end == s.length()){
                        return true;
                    }
                }
            }
            visited[start] = true;
        }
        return false;
    }

    //DP
    public boolean wordBreakDP(String s, List<String> wordDict){
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i < s.length() + 1; i++){
            for (int j = 0; j < i; j++) {
                if(dp[j] && wordDictSet.contains(s.substring(j, i))){
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
