package com.ctci;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestOneAway {
    OneAway obj;
    @BeforeEach
    public void setUp(){
        obj = new OneAway();
    }
    @Test
    public void testOneAway(){
        Assertions.assertTrue(obj.oneAway("pale", "ple"));
        Assertions.assertTrue(obj.oneAway("pales", "pale"));
        Assertions.assertTrue(obj.oneAway("pale", "bale"));
        Assertions.assertFalse(obj.oneAway("pale", "bake"));
    }
}
