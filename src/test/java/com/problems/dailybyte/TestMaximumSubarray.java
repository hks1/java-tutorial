package com.problems.dailybyte;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestMaximumSubarray {
    MaximumSubarray obj;
    @BeforeEach
    public void setUp(){
        obj = new MaximumSubarray();
    }
    /*
    Ex: Given the following integer arrays…

nums = [-3,8,-8,2], return 8 (8)
nums = [2, 3,-4, 2], return 5 (2 + 3)
nums = [1, 5,-2, -3, 7], return 8 (1 + 5 + (-2) + (-3) + 7)

     */
    @Test
    public void test(){
        Assertions.assertEquals(8, obj.maxSum(new int[]{-3, 8, -8, 2}));
        Assertions.assertEquals(5, obj.maxSum(new int[]{2,3,-4,2}));
        Assertions.assertEquals(8, obj.maxSum(new int[]{1,5,-2,-3,7}));
    }
}
