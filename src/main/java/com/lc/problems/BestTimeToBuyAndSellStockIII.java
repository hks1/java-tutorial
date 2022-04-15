package com.lc.problems;

public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        /***
         * input: prices array with prices[i] is the price on day i
         * return: max profit with at most two transactions
         */
        int maxProfit = 0;
        // check for 1 transaction
        int profit = 0;
        for(int i = 0; i < prices.length; i++){
            profit = 0;
            for(int j = i+1; j < prices.length; j++){
                profit = prices[j] - prices[i];
                maxProfit = Math.max(profit, maxProfit);
            }
        }
        for(int i = 0; i < prices.length; i++){
            for(int j = i+1; j < prices.length; j++){
                maxProfit = Math.max(maxProfit, maxProfitBetweenTwoDays(prices, i, j) + maxProfitBetweenTwoDays(prices, j+1, prices.length-1));
            }
        }
        return maxProfit;
    }

    public int profitBetweenTwoDays(int[] prices, int buyDate, int sellDate){
        /***
         * assumption: buyDate and sellDate are within array indices bounds
         * prices array: prices[i] is price on ith day
         * returns: 0, if sellDate <= buyDate
         *          prices[sellDate] - prices[buyDate]
         */
        if(sellDate <= buyDate) return 0;
        return prices[sellDate] - prices[buyDate];
    }

    public int maxProfitBetweenTwoDays(int[] prices, int buyDate, int sellDate){
        /***
         * assumption: buyDate and sellDate are within array indices bounds
         * prices array: prices[i] is price on ith day
         * returns: 0, if sellDate <= buyDate
         *          max profit between buyDate and sellDate
         */
        if(sellDate <= buyDate) return 0;
        //return prices[sellDate] - prices[buyDate];
        int max = 0;
        for(int i = buyDate; i <= sellDate; i++){
            for(int j = i + 1; j <= sellDate; j++){
                max = Math.max(max, prices[j] - prices[i]);
            }
        }
        return max;
    }
}
