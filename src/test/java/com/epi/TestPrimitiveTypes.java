package com.epi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestPrimitiveTypes {
    PrimitiveTypes obj;
    @BeforeEach
    public void setUp(){
        obj = new PrimitiveTypes();
    }
    @Test
    @DisplayName("Right propagate the rightmost set bit - tc 1: 10 -> 11")
    public void testRightPropagateRightMostSetBitTC1Pass(){
        Assertions.assertEquals(11, obj.rightPropagateRightMostSetBit(10));
    }
    @Test
    @DisplayName("Right propagate the rightmost set bit - tc 2: 64 -> 127")
    public void testRightPropagateRightMostSetBitTC2Pass(){
        Assertions.assertEquals(127, obj.rightPropagateRightMostSetBit(64));
    }
    @Test
    @DisplayName("is power of 2 - check for 64 - expects true")
    public void testIsPowerOfTwoFor64(){
        Assertions.assertEquals(true, obj.isPowerOfTwo(64));
    }
    @Test
    @DisplayName("is power of 2 - check for 1 - expects true")
    public void testIsPowerOfTwoFor1(){
        Assertions.assertEquals(true, obj.isPowerOfTwo(1));
    }
    @Test
    @DisplayName("is power of 2 - check for 63 - expects false")
    public void testIsPowerOfTwoFor63(){
        Assertions.assertEquals(false, obj.isPowerOfTwo(63));
    }
}
