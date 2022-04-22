package com.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestMedianFinder {
    MedianFinder obj;

    @BeforeEach
    public void setUp(){
        obj = new MedianFinder();
    }

    @Test
    @DisplayName("test case 1")
    public void testMedianFinderOne(){
        obj.addNum(-1);
        Assertions.assertEquals(obj.findMedian(), -1.0);
        obj.addNum(-2);
        Assertions.assertEquals(obj.findMedian(), -1.5);
        obj.addNum(-3);
        Assertions.assertEquals(obj.findMedian(), -2.0);
        obj.addNum(-4);
        Assertions.assertEquals(obj.findMedian(), -2.5);
        obj.addNum(-5);
        Assertions.assertEquals(obj.findMedian(), -3.0);
    }
}
