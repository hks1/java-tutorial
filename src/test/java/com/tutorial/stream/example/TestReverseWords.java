package com.tutorial.stream.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestReverseWords {
    ReverseWords obj;
    @BeforeEach
    public void setUp(){
        obj = new ReverseWords();
    }
    @Test
    @DisplayName("Test 1")
    public void testReverseWordsTest1(){
        Assertions.assertEquals("gnidoc si looc", obj.reverseWords("coding is cool"));
    }
}
