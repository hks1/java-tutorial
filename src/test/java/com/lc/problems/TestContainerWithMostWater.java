package com.lc.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestContainerWithMostWater {
    ContainerWithMostWater obj;
    @BeforeEach
    public void setUp(){
        obj = new ContainerWithMostWater();
    }
    @Test
    @DisplayName("Container with most water test case 1")
    public void testContainerWithMostWater(){
        Assertions.assertEquals(49, obj.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
