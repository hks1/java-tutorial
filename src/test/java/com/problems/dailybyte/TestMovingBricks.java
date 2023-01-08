package com.problems.dailybyte;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestMovingBricks {
    MovingBricks obj;
    @BeforeEach
    public void setUp(){
        obj = new MovingBricks();
    }
    @Test
    public void testMaxNumBricks(){
        Assertions.assertEquals(3, obj.maxNumBricks(new int[] {1000, 1000, 1000, 2000}, 5000));
        Assertions.assertEquals(4, obj.maxNumBricks(new int[] {1000, 200, 150, 200}, 5000));
    }
}
