package com.lc.problems;

import com.lc.problems.HouseRobber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestHouseRobber {
    private HouseRobber robber;

    @BeforeEach
    public void setUp(){
        robber = new HouseRobber();
    }

    @Test
    @DisplayName("Test 1")
    public void testHouseRobberTCOne(){
        Assertions.assertEquals(4, robber.rob(new int[]{1,2,3,1}));
    }

    @Test
    @DisplayName("Test 2")
    public void testHouseRobberTCTwo(){
        Assertions.assertEquals(12, robber.rob(new int[]{2,7,9,3,1}));
    }
}
