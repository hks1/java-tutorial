package com.problems.dailybyte;

import com.problems.dailybyte.SpotTheDifference;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestSpotTheDifference {
    SpotTheDifference obj;
    @BeforeEach
    public void setUp(){
        obj = new SpotTheDifference();
    }
    @Test
    public void testSpotTheDifference(){
        Assertions.assertEquals('t', obj.spotTheDifference("foobar", "barfoot"));
        Assertions.assertEquals('a', obj.spotTheDifference("ide", "idea"));
        Assertions.assertEquals('\0', obj.spotTheDifference("coding", "ingcod"));
    }
}
