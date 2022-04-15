package com.lc.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
public class TestSlidingWindowMaximum {
    SlidingWindowMaximum obj;
    @BeforeEach
    public void setUp(){
        obj = new SlidingWindowMaximum();
    }
    @Test
    @DisplayName("Test 1")
    public void testSlidingWindowMaximumTestCase1(){
        Assertions.assertArrayEquals(new int[]{3,3,5,5,6,7}, obj.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3));
        Assertions.assertArrayEquals(new int[]{1}, obj.maxSlidingWindow(new int[]{1}, 1));
        Assertions.assertArrayEquals(new int[]{7,7,7,7,7}, obj.maxSlidingWindow(new int[]{-7,-8,7,5,7,1,6,0}, 4));
    }
}
