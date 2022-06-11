package com.lc.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestCoinChange {
    CoinChange obj;
    @BeforeEach
    public void setUp(){
        obj = new CoinChange();
    }
    @Test
    public void testCoinChange(){
        //Example 1:
        //
        //Input: coins = [1,2,5], amount = 11
        //Output: 3
        //Explanation: 11 = 5 + 5 + 1
        //Example 2:
        //
        //Input: coins = [2], amount = 3
        //Output: -1
        //Example 3:
        //
        //Input: coins = [1], amount = 0
        //Output: 0
        Assertions.assertEquals(3, obj.coinChange(new int[]{1,2,5}, 11));
        Assertions.assertEquals(-1, obj.coinChange(new int[]{2}, 3));
        Assertions.assertEquals(0, obj.coinChange(new int[]{1}, 0));
    }
    @Test
    public void testCoinChangDP(){
        //Example 1:
        //
        //Input: coins = [1,2,5], amount = 11
        //Output: 3
        //Explanation: 11 = 5 + 5 + 1
        //Example 2:
        //
        //Input: coins = [2], amount = 3
        //Output: -1
        //Example 3:
        //
        //Input: coins = [1], amount = 0
        //Output: 0
        Assertions.assertEquals(3, obj.coinChangeDP(new int[]{1,2,5}, 11));
        Assertions.assertEquals(-1, obj.coinChangeDP(new int[]{2}, 3));
        Assertions.assertEquals(0, obj.coinChangeDP(new int[]{1}, 0));
    }
    @Test
    public void testCoinChangeII(){
        //Example 1:
        //
        //Input: amount = 5, coins = [1,2,5]
        //Output: 4
        //Explanation: there are four ways to make up the amount:
        //5=5
        //5=2+2+1
        //5=2+1+1+1
        //5=1+1+1+1+1
        //Example 2:
        //
        //Input: amount = 3, coins = [2]
        //Output: 0
        //Explanation: the amount of 3 cannot be made up just with coins of 2.
        //Example 3:
        //
        //Input: amount = 10, coins = [10]
        //Output: 1
        Assertions.assertEquals(4, obj.change(5, new int[]{1,2,5}));
        Assertions.assertEquals(0, obj.change(3, new int[]{2}));
        Assertions.assertEquals(1, obj.change(10, new int[]{10}));
    }
}
