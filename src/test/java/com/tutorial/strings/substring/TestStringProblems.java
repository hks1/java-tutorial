package com.tutorial.strings.substring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

public class TestStringProblems {
    StringProblems obj;
    @BeforeEach
    public void setUp(){
        obj = new StringProblems();
    }
    @Test
    @DisplayName("shortest controlling set test")
    public void testShortestControllingSet(){
        Assertions.assertEquals(4, obj.shortestControllingSet("helloworld", new HashSet<>(Arrays.asList('l', 'r', 'w'))));
    }
}
