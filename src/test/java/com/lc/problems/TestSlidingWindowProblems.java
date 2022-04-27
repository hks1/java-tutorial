package com.lc.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestSlidingWindowProblems {
    SlidingWindowProblems obj;
    @BeforeEach
    public void setUp(){
        obj = new SlidingWindowProblems();
    }
    // 346. Moving Average from Data Stream
    @Test
    @DisplayName("// 346. Moving Average from Data Stream")
    public void testMovingAverage(){
        MovingAverage obj = new MovingAverage(3);
        Assertions.assertEquals(1.0, obj.next(1));
        Assertions.assertEquals(5.5, obj.next(10));
        Assertions.assertEquals(4.6667, obj.next(3));
        Assertions.assertEquals(6.0, obj.next(5));
    }
    // 643. Maximum Average Subarray I
    @Test
    @DisplayName("// 643. Maximum Average Subarray I")
    public void testFindMaxAverage(){
        Assertions.assertEquals(12.75000, obj.findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4));
        Assertions.assertEquals(5.00000, obj.findMaxAverage(new int[]{5}, 1));
    }
    // 1343. Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold
    @Test
    @DisplayName("// 1343. Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold")
    public void testNumOfSubarrays(){
        Assertions.assertEquals(3, obj.numOfSubarrays(new int[]{2,2,2,2,5,5,5,8}, 3, 4));
        Assertions.assertEquals(6, obj.numOfSubarrays(new int[]{11,13,17,23,29,31,7,5,2,3}, 3, 5));
    }
    // 1176. Diet Plan Performance
    @Test
    @DisplayName("// 1176. Diet Plan Performance")
    public void testDietPlanPerformance(){
        Assertions.assertEquals(0, obj.dietPlanPerformance(new int[]{1,2,3,4,5}, 1, 3, 3));
        Assertions.assertEquals(1, obj.dietPlanPerformance(new int[]{3,2}, 2,0, 1));
        Assertions.assertEquals(0, obj.dietPlanPerformance(new int[]{6,5,0,0}, 2,1, 5));
    }
    //1052. Grumpy Bookstore Owner
    @Test
    @DisplayName("//1052. Grumpy Bookstore Owner")
    public void testMaxSatisfied(){
        Assertions.assertEquals(16, obj.maxSatisfied(new int[]{1,0,1,2,1,1,7,5}, new int[]{0,1,0,1,0,1,0,1}, 3));
        Assertions.assertEquals(1, obj.maxSatisfied(new int[]{1}, new int[]{0}, 1));
        Assertions.assertEquals(18, obj.maxSatisfied(new int[]{10,1,7}, new int[]{0,0,0}, 2));
    }
    // 1456. Maximum Number of Vowels in a Substring of Given Length
    @Test
    @DisplayName("// 1456. Maximum Number of Vowels in a Substring of Given Length")
    public void testMaxVowels() {
        Assertions.assertEquals(3, obj.maxVowels("abciiidef", 3));
        Assertions.assertEquals(2, obj.maxVowels("aeiou", 2));
        Assertions.assertEquals(2, obj.maxVowels("leetcode", 3));
    }
    // 1100. Find K-Length Substrings With No Repeated Characters
    @Test
    @DisplayName("// 1100. Find K-Length Substrings With No Repeated Characters")
    public void testNumKLenSubstrNoRepeats() {
        Assertions.assertEquals(6, obj.numKLenSubstrNoRepeats("havefunonleetcode", 5));
        Assertions.assertEquals(0, obj.numKLenSubstrNoRepeats("home", 5));
    }
    // 239. Sliding Window Maximum
    @Test
    @DisplayName("// 239. Sliding Window Maximum")
    public void testMaxSlidingWindow(){
        Assertions.assertArrayEquals(new int[]{3,3,5,5,6,7}, obj.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3));
        Assertions.assertArrayEquals(new int[]{1}, obj.maxSlidingWindow(new int[]{1}, 1));
    }
}
