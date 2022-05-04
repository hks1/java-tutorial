package com.ctci;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestZeroMatrix {
    ZeroMatrix obj;
    @BeforeEach
    public void setUp(){
        obj = new ZeroMatrix();
    }
    @Test
    public void testZeroMatrix(){
        Assertions.assertArrayEquals(new int[][]{{0,0,0}, {3,0,5}, {6,0,8}}, obj.zeroMatrix(new int[][]{{1,0,2}, {3,4,5}, {6,7,8}}));
        Assertions.assertArrayEquals(new int[][]{{1,0,3}, {0,0,0}, {7,0,9}}, obj.zeroMatrix(new int[][]{{1,2,3}, {4,0,6}, {7,8,9}}));
    }
}
