package com.tutorial.arrays;

//import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestRemoveEven {
    RemoveEven obj;
    @BeforeEach
    public void setUp(){
        obj = new RemoveEven();
    }
    @Test
    public void testRemoveEven(){
        Assertions.assertArrayEquals(new int[]{1,5,3}, obj.removeEven(new int[]{1,5,4,2,10,6,3}));
    }
}
