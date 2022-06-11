package com.lc.problems;

public class LongestCommonSubsequence {

    //1143. Longest Common Subsequence
    //Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
    //
    //A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
    //
    //For example, "ace" is a subsequence of "abcde".
    //A common subsequence of two strings is a subsequence that is common to both strings.
    public int longestCommonSubsequence(String s1, String s2){
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i < m+1; i++){
            dp[i][0] = 0;
        }
        for (int i = 0; i < n + 1; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
    //brute force
    public int lcsbf(String s1, String s2){
        if(s1.length() * s2.length() == 0){
            return 0;
        }
        if(s1.charAt(0) == s2.charAt(0)){
            return 1 + lcsbf(s1.substring(1), s2.substring(1));
        }else{
            return Math.max(lcsbf(s1, s2.substring(1)), lcsbf(s1.substring(1), s2));
        }
    }
}
