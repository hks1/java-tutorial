package com.lc.problems;

public class CoinChange {
    //322. Coin Change
    //You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
    //
    //Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
    //
    //You may assume that you have an infinite number of each kind of coin.
    public int coinChange(int[] coins, int amount){
        if(amount == 0){
            return 0;
        }
        int[] result = {0, 0}; // min coins, current count
        helper(coins, amount, 0, result);
        //return result[0] == 0 ? -1 : result[0];
        return result[0] == 0 ? -1 : result[0];
    }

    public void helper(int[] coins, int amount, int index, int[] result){
        if(amount < 0){
            return;
        }
        if(amount == 0){
            result[0] = Math.max(result[0], result[1]);
        }
        // recursive
        for(int i = index; i < coins.length; i++){
            result[1]++;
            helper(coins, amount-coins[i], index+1, result);
            result[1]--;
        }
    }

    public int coinChangeDP(int[] coins, int amount){
        if(amount == 0){
            return 0;
        }
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for(int i = 1; i <= amount; i++){
            int min = amount + 1;
            for(int coin : coins){
                if(i-coin >= 0){
                    min = Math.min(min, dp[i-coin]);
                }
            }
            dp[i] = min + 1;
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    //518. Coin Change 2
    //You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
    //
    //Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.
    //
    //You may assume that you have an infinite number of each kind of coin.
    //
    //The answer is guaranteed to fit into a signed 32-bit integer.
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int coin : coins){
            for (int i = coin; i < amount + 1; i++) {
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }
}
