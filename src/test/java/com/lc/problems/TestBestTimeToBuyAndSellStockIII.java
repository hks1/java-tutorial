package com.lc.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestBestTimeToBuyAndSellStockIII {
    BestTimeToBuyAndSellStockIII obj;
    @BeforeEach
    public void setUp(){
        obj = new BestTimeToBuyAndSellStockIII();
    }
    @Test
    @DisplayName("test case 1 - pass")
    public void testBestTimeToBuyAndSellStock(){
        Assertions.assertEquals(6, obj.maxProfit(new int[]{3,3,5,0,0,3,1,4}));
    }
}
