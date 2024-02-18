package com.lc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoSumTest {

    TwoSum obj;

    @BeforeEach
    void setUp() {
        obj = new TwoSum();
    }

    @Test
    void twoSum() {
        Assertions.assertArrayEquals(new int[]{2,3}, obj.twoSum(new int[]{0,1,4,3,5}, 7));
        Assertions.assertArrayEquals(new int[]{0,1}, obj.twoSum(new int[]{2,7,11,15}, 9));
    }
}