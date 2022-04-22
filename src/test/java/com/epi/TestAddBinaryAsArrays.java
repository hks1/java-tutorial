package com.epi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TestAddBinaryAsArrays {
    AddBinaryAsArrays obj;
    @BeforeEach
    public void setup(){
        obj = new AddBinaryAsArrays();
    }
    @Test
    @DisplayName("add binary numbers give as arrays - tc 1")
    public void testAddBinaryAsArraysTC1(){
        int[] b1 = {1,0,1};
        int[] b2 = {1,1,1};
        //Assertions.assertEquals(Arrays.asList(1,1,0,0), obj.addBinary(b1, b2));
        Assertions.assertEquals(Arrays.asList(1,1,0,0), obj.addBinary(new int[]{1,0,1}, new int[]{1,1,1}));
        Assertions.assertEquals(Arrays.asList(1,0,0,0), obj.addBinary(new int[]{1,0,1}, new int[]{1,1}));
    }
}
