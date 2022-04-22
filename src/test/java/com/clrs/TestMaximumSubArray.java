package com.clrs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestMaximumSubArray {
    MaximumSubArray obj;
    @BeforeEach
    public void setUp(){
        obj = new MaximumSubArray();
    }
    @Test
    @DisplayName("find max subarray - test case 1")
    public void testFindMaxSubArrayTestCase1(){
        Assertions.assertEquals(9, obj.findMaxSubArray(new int[]{-1,2,3,4,-5}));
        Assertions.assertEquals(6, obj.findMaxSubArray(new int[]{-1,2,-3,4,-5,6}));
    }
}
