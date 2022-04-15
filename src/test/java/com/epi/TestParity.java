package com.epi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestParity {
    Parity obj;
    @BeforeEach
    public void setUp(){
        obj = new Parity();
    }
    @Test
    @DisplayName("test parity test 1")
    public void testParityTC1(){
        Assertions.assertEquals(1, obj.parity(1));
        Assertions.assertEquals(1, obj.parityBruteForce(1));
        Assertions.assertEquals(1, obj.computeParityWithCachedResults(1));
        Assertions.assertEquals(1, obj.computeParityWithCachedResults(Long.MAX_VALUE));
        Assertions.assertEquals(1, obj.parityLogNOrder(1));
    }
    @Test
    @DisplayName("test parity test 2")
    public void testParityTC2(){
        Assertions.assertEquals(0, obj.parity(63));
        Assertions.assertEquals(0, obj.parityBruteForce(63));
        Assertions.assertEquals(0, obj.computeParityWithCachedResults(63));
        Assertions.assertEquals(0, obj.parityLogNOrder(63));
    }
    @Test
    @DisplayName("test parity test 3")
    public void testParityTC3(){
        Assertions.assertEquals(1, obj.parity(64));
        Assertions.assertEquals(1, obj.parityBruteForce(64));
        Assertions.assertEquals(1, obj.computeParityWithCachedResults(64));
        Assertions.assertEquals(1, obj.parityLogNOrder(64));
    }
    @Test
    @DisplayName("test parity test 4")
    public void testParityTC4(){
        short parity = obj.parity(Long.MAX_VALUE-1);
        System.out.println(parity);
        //Assertions.assertEquals(1, obj.parity(Long.MAX_VALUE));
        Assertions.assertEquals(1, obj.parity(Long.MAX_VALUE));
        Assertions.assertEquals(1, obj.parityBruteForce(Long.MAX_VALUE));
        Assertions.assertEquals(1, obj.computeParityWithCachedResults(Long.MAX_VALUE));
        Assertions.assertEquals(1, obj.parityLogNOrder(Long.MAX_VALUE));
    }
}
