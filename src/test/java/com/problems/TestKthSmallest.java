package com.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestKthSmallest {
    KthSmallest obj;
    @BeforeEach
    public void setUp(){
        obj = new KthSmallest();
    }
    @Test
    public void testKthSmallest(){
        Assertions.assertEquals(3, obj.kthSmallest(new int[]{1,2,3,4,5,6,7}, 0, 6, 3));
        Assertions.assertEquals(3, obj.kthSmallest(new int[]{7,6,5,4,3,2,1}, 0, 6, 3));
    }
}
