package com.epi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestSwapBits {
    SwapBits obj;
    @BeforeEach
    public void setUp(){
        obj = new SwapBits();
    }
    @Test
    @DisplayName("swap bits test 1")
    public void testSwapBitsTC1(){
        Assertions.assertEquals(8, obj.swapBits(8, 1,2));
        Assertions.assertEquals(28, obj.swapBits(21, 0,3));
    }
}
