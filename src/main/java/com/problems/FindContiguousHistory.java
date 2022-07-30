package com.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindContiguousHistory {
    // indeed karat
    // similar to longest common subarray
    public String[] fidContiguousHistory(String[] user0, String[] user1){
        List<String> result = new ArrayList<>();
        int maxLength = 0;
        int maxIndex = -1;
        int m = user0.length;
        int n = user1.length;
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < n + 1; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if(user0[i-1].equals(user1[j-1])){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    if(dp[i][j] > maxLength){
                        maxLength = dp[i][j];
                        maxIndex =  j;
                    }
                }
            }

        }
        return Arrays.copyOfRange(user1, maxIndex - maxLength , maxIndex ); // maxIndex is exclusive
    }
}

class TDFindContiguousHistory{
    public static void main(String[] args) {
        String[] user0 = {"/start", "/green", "/blue", "/pink", "/register", "/orange", "/one/two"};
        String[] user1 = {"/start", "/pink", "/register", "/orange", "/red", "a"};
        FindContiguousHistory obj = new FindContiguousHistory();
        String[] result = obj.fidContiguousHistory(user0, user1);
        System.out.println(Arrays.toString(result));
    }
}

/*
We have some clickstream data that we gathered on our client's website. Using cookies, we collected snippets of users' anonymized URL histories while they browsed the site. The histories are in chronological order, and no URL was visited more than once per person.

Write a function that takes two users' browsing histories as input and returns the longest contiguous sequence of URLs that appears in both.

Sample input:

user0 = ["/start", "/green", "/blue", "/pink", "/register", "/orange", "/one/two"]
user1 = ["/start", "/pink", "/register", "/orange", "/red", "a"]
user2 = ["a", "/one", "/two"]
user3 = ["/pink", "/orange", "/yellow", "/plum", "/blue", "/tan", "/red", "/amber", "/HotRodPink", "/CornflowerBlue", "/LightGoldenRodYellow", "/BritishRacingGreen"]
user4 = ["/pink", "/orange", "/amber", "/BritishRacingGreen", "/plum", "/blue", "/tan", "/red", "/lavender", "/HotRodPink", "/CornflowerBlue", "/LightGoldenRodYellow"]
user5 = ["a"]
user6 = ["/pink","/orange","/six","/plum","/seven","/tan","/red", "/amber"]

Sample output:

findContiguousHistory(user0, user1) => ["/pink", "/register", "/orange"]
findContiguousHistory(user0, user2) => [] (empty)
findContiguousHistory(user0, user0) => ["/start", "/green", "/blue", "/pink", "/register", "/orange", "/one/two"]
findContiguousHistory(user2, user1) => ["a"]
findContiguousHistory(user5, user2) => ["a"]
findContiguousHistory(user3, user4) => ["/plum", "/blue", "/tan", "/red"]
findContiguousHistory(user4, user3) => ["/plum", "/blue", "/tan", "/red"]
findContiguousHistory(user3, user6) => ["/tan", "/red", "/amber"]

n: length of the first user's browsing history
m: length of the second user's browsing history
*/
