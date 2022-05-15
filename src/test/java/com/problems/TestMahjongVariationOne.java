package com.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestMahjongVariationOne {
    MahjongVariationOne obj;
    @BeforeEach
    public void setUp(){
        obj = new MahjongVariationOne();
    }
    @Test
    public void testComplete(){
        Assertions.assertTrue(obj.complete("11122233"));
    }
}
