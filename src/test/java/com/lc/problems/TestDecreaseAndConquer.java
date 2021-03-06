package com.lc.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestDecreaseAndConquer {
    DecreaseAndConquer obj;
    @BeforeEach
    public void setUp(){
        obj = new DecreaseAndConquer();
    }
    //969. Pancake Sorting
    @Test
    @DisplayName("//969. Pancake Sorting")
    public void testPancakeSort(){

    }
    //280. Wiggle Sort
    @Test
    @DisplayName("//280. Wiggle Sort")
    public void testWiggleSort(){
        int[] nums = new int[]{3,5,2,1,6,4};
        obj.wiggleSort(nums);
        Assertions.assertArrayEquals(new int[]{3,5,1,6,2,4}, nums);
        int[] nums2 = new int[]{1,2,2,1,2,1,1,1,1,3,2,2};
        obj.wiggleSort(nums2);
        Assertions.assertArrayEquals(new int[]{1, 2, 1, 2, 1, 2, 1, 1, 1, 3, 2, 2}, nums2);
    }
    //240. Search a 2D Matrix II
    @Test
    @DisplayName("//240. Search a 2D Matrix II")
    public void testSearchMatrix(){
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        /*Assertions.assertEquals(true, obj.searchMatrix(matrix, 5));
        Assertions.assertEquals(false, obj.searchMatrix(matrix, 20));*/
        Assertions.assertTrue( obj.searchMatrix(matrix, 5));
        Assertions.assertFalse(obj.searchMatrix(matrix, 20));
    }
    // 53. Maximum Subarray
    @Test
    @DisplayName("// 53. Maximum Subarray")
    public void testMaxSubArray(){
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        Assertions.assertEquals(6, obj.maxSubArray(arr));
    }
    //121. Best Time to Buy and Sell Stock
    @Test
    @DisplayName("//121. Best Time to Buy and Sell Stock")
    public void testMaxProfit(){
        int[] stocks = {7,1,5,3,6,4};
        Assertions.assertEquals(5, obj.maxProfit(stocks));
    }
    // 221. Maximal Square
    @Test
    @DisplayName("// 221. Maximal Square")
    public void testMaximalSquare(){
        int[][] matrix = {{1,0,1,0,0},{1,0,1,1,1},{1,1,1,1,1},{1,0,0,1,0}};
        Assertions.assertEquals(4, obj.maximalSquare(matrix));
        Assertions.assertEquals(1, obj.maximalSquare(new int[][]{{0,1},{1,0}}));
        Assertions.assertEquals(0, obj.maximalSquare(new int[][]{{0}}));
    }
}
