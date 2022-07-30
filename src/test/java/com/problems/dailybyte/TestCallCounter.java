package com.problems.dailybyte;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

public class TestCallCounter {
    CallCounter obj;
    @BeforeEach
    public void setUp(){
        obj = new CallCounter();
    }
    @Test
    public void testPing(){
        ////Ex: Given the following calls to ping…
        //    //
        //    //ping(1), return 1 (1 call within the last 3 seconds)
        //    //ping(300), return 2 (2 calls within the last 3 seconds)
        //    //ping(3000), return 3 (3 calls within the last 3 seconds)
        //    //ping(3002), return 3 (3 calls within the last 3 seconds)
        //    //ping(7000), return 1 (1 call within the last 3 seconds)
        obj = new CallCounter();
        Assertions.assertEquals(1, obj.ping(1));
        Assertions.assertEquals(2, obj.ping(300));
        Assertions.assertEquals(3, obj.ping(2900));
        Assertions.assertEquals(4, obj.ping(3000));
        //Assertions.assertEquals(3, obj.ping(3001));
        Assertions.assertEquals(4, obj.ping(3002));
        Assertions.assertEquals(1, obj.ping(7000));
    }
}
