package com.problems.patterns.slidingwindow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestAvgOfSubarrayOfSizeK {
    AvgOfSubarrayOfSizeK obj;
    @BeforeEach
    public void setup(){
        obj = new AvgOfSubarrayOfSizeK();
    }
    @Test
    public void testAverageOfSubarrayOfSizeK(){
        Assertions.assertArrayEquals(new double[]{4.0,5.0,6.0}, obj.findAverages(new int[]{2,6,4,8}, 2));
        Assertions.assertArrayEquals(null, obj.findAverages(new int[]{2,6,4,8}, 5));
        Assertions.assertArrayEquals(new double[]{5.0}, obj.findAverages(new int[]{2,6,4,8}, 4));
    }
}
