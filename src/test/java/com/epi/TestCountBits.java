package com.epi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestCountBits {
    CountBits obj;
    @BeforeEach
    public void setUp(){
        obj = new CountBits();
    }
    @Test
    @DisplayName("test count bits test case 1 - count bits in 1")
    public void testCountBitsIn1(){
        Assertions.assertEquals(1, obj.countBits(1));
    }
    @Test
    @DisplayName("test count bits test case 2 - count bits in 63")
    public void testCountBitsIn63(){
        Assertions.assertEquals(6, obj.countBits(63));
    }
    @Test
    @DisplayName("test count bits test case 3 - count bits in 64")
    public void testCountBitsIn64(){
        Assertions.assertEquals(1, obj.countBits(1));
    }
}
