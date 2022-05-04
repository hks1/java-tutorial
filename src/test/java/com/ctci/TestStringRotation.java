package com.ctci;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestStringRotation {
    StringRotation obj;
    @BeforeEach
    public void setUp(){
        obj = new StringRotation();
    }
    @Test
    public void testStringRotation(){
        Assertions.assertTrue(obj.stringRotation("waterbottle", "erbottlewat"));
    }
}
