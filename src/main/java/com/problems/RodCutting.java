package com.problems;

public class RodCutting {
    public int rodCutting(int[] prices, int length){
        //int maxProfit = Integer.MIN_VALUE;
        int[] dp = new int[length+1];
        dp[0] = 0;
        for(int i = 1; i < dp.length; i++){
            int maxValue = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                maxValue = Math.max(maxValue, prices[j] + dp[i-j-1]);
            }
            dp[i] = maxValue;
        }
        return dp[prices.length];
    }
}

class TDRodCutting{
    public static void main(String[] args) {
        RodCutting obj = new RodCutting();
        int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20};
        int size = arr.length;
        System.out.println(obj.rodCutting(arr, size));
    }
}
