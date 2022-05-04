package com.ctci;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestStringCompression {
    StringCompression obj;
    @BeforeEach
    public void setUp(){
        obj = new StringCompression();
    }
    @Test
    public void testStringCompression(){
        Assertions.assertEquals("a2b1c5a3", obj.stringCompression("aabcccccaaa"));
        Assertions.assertEquals("abc", obj.stringCompression("abc"));
    }
}
