package com.lc.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestJumpGame {
    JumpGame obj;
    @BeforeEach
    public void setUp(){
        obj = new JumpGame();
    }
    @Test
    public void testJumpGameII(){
        //Example 1:
        //
        //Input: nums = [2,3,1,1,4]
        //Output: 2
        //Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
        //Example 2:
        //
        //Input: nums = [2,3,0,1,4]
        //Output: 2
        Assertions.assertEquals(2, obj.jump(new int[]{2,3,1,1,4}));
        Assertions.assertEquals(2, obj.jump(new int[]{2,3,0,1,4}));
    }
}
