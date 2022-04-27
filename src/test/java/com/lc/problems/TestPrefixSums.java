package com.lc.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class TestPrefixSums {
    PrefixSums obj;
    @BeforeEach
    public void setUp(){
        obj = new PrefixSums();
    }
    // 1480. Running Sum of 1d Array
    @Test
    @DisplayName("// 1480. Running Sum of 1d Array")
    public void testRunningSum(){
        Assertions.assertArrayEquals(new int[]{1,3,6,10}, obj.runningSum(new int[]{1,2,3,4}));
    }
    // 303. Range Sum Query - Immutable
    @Test
    @DisplayName("// 303. Range Sum Query - Immutable")
    public void testSumRange(){
        NumArray obj = new NumArray(new int[]{-2,0,3,-5,2,-1});
        Assertions.assertEquals(1, obj.sumRange(0,2));
        Assertions.assertEquals(-1, obj.sumRange(2,5));
        Assertions.assertEquals(-3, obj.sumRange(0,5));
    }
    //304. Range Sum Query 2D - Immutable
    @Test
    @DisplayName("//304. Range Sum Query 2D - Immutable")
    public void testSumRegion(){

        int[][] arr = new int[][]{{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}};
        NumMatrix obj = new NumMatrix(arr);
        Assertions.assertEquals(8, obj.sumRegion(2,1,4,3));
        Assertions.assertEquals(11, obj.sumRegion(1,1,2,2));
        Assertions.assertEquals(12, obj.sumRegion(1,2,2,4));

    }
    //560. Subarray Sum Equals K
    @Test
    @DisplayName("//560. Subarray Sum Equals K")
    public void testSubarraySum(){
        Assertions.assertEquals(2, obj.subarraySum(new int[]{1,1,1}, 2));
        Assertions.assertEquals(2, obj.subarraySum(new int[]{1,2,3}, 3));
    }
    // 974. Subarray Sums Divisible by K
    @Test
    @DisplayName("// 974. Subarray Sums Divisible by K")
    public void testSubarraysDivByK(){
        Assertions.assertEquals(7, obj.subarraysDivByK(new int[]{4,5,0,-2,-3,1}, 5));
        Assertions.assertEquals(0, obj.subarraysDivByK(new int[]{5}, 9));
    }
    //325. Maximum Size Subarray Sum Equals k
    @Test
    @DisplayName("//325. Maximum Size Subarray Sum Equals k")
    public void testMaxSubArrayLen(){
        Assertions.assertEquals(4, obj.maxSubArrayLen(new int[]{1,-1,5,-2,3}, 3));
        Assertions.assertEquals(2, obj.maxSubArrayLen(new int[]{-2,-1,2,1}, 1));
    }
    @Test
    @DisplayName("//325. Maximum Size Subarray Sum Equals k")
    public void testMaxSubArrayLenBruteForce(){
        Assertions.assertEquals(4, obj.maxSubArrayLenBruteForce(new int[]{1,-1,5,-2,3}, 3));
        Assertions.assertEquals(2, obj.maxSubArrayLenBruteForce(new int[]{-2,-1,2,1}, 1));
    }
    // 1524. Number of Sub-arrays With Odd Sum
    @Test
    @DisplayName("// 1524. Number of Sub-arrays With Odd Sum")
    public void testNumOfSubarrays(){
        Assertions.assertEquals(4, obj.numOfSubarrays(new int[]{1,3,5}));
        Assertions.assertEquals(0, obj.numOfSubarrays(new int[]{2,4,6}));
        Assertions.assertEquals(16, obj.numOfSubarrays(new int[]{1,2,3,4,5,6,7}));
        Assertions.assertEquals(4, obj.numOfSubarrays(new int[]{100,100,99,99}));
        Assertions.assertEquals(1, obj.numOfSubarrays(new int[]{7}));
    }
    // 525. Contiguous Array
    @Test
    @DisplayName("// 525. Contiguous Array")
    public void testFindMaxLength(){
        Assertions.assertEquals(2, obj.findMaxLength(new int[]{0,1}));
        Assertions.assertEquals(2, obj.findMaxLength(new int[]{0,1, 0}));
    }
    // 523. Continuous Subarray Sum
    @Test
    @DisplayName("// 523. Continuous Subarray Sum")
    public void testCheckSubarraySum(){
        Assertions.assertTrue(obj.checkSubarraySum(new int[]{23,2,4,6,7}, 6));
        Assertions.assertTrue(obj.checkSubarraySum(new int[]{23,2,6,4,7}, 6));
        Assertions.assertFalse(obj.checkSubarraySum(new int[]{23,2,6,4,7}, 13));
    }
}
