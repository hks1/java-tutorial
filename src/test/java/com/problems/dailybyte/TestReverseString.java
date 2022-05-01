package com.problems.dailybyte;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestReverseString {
    ReverseString obj;
    @BeforeEach
    public void setUp(){
        obj = new ReverseString();
    }
    @Test
    public void testReverseString(){
        Assertions.assertEquals("civic", obj.reverse("civic"));
        Assertions.assertEquals("taC", obj.reverse("Cat"));
        Assertions.assertEquals("etyB yliaD ehT", obj.reverse("The Daily Byte"));
        Assertions.assertEquals("etyB yliaD ehT", obj.reverse("The Daily Byte1"));
    }
}
