package com.tutorial.lil;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlgorithmsTest {

    Algorithms obj;

    @BeforeEach
    void setUp() {
        obj = new Algorithms();
    }

    @Test
    void normalizeString() {
        assertEquals("dehradun", obj.normalizeString("Dehradun,"));
        assertEquals("baseball", obj.normalizeString("baSeBa,ll"));
        assertEquals("hello there buddy", obj.normalizeString("   HellO There, BUDDY,"));
    }

    @Test
    void searchSubstring(){
        assertEquals(true, obj.searchSubstring("test string", "est"));
    }

    @Test
    void reversed(){
        assertEquals("", obj.reversed(""));
        assertEquals(null, obj.reversed(null));
        assertEquals("ananab", obj.reversed("banana"));
    }
}