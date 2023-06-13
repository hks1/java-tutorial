package com.strings;

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
    void reverseWords() {
        assertEquals("one red appleE!", obj.reverseWords("eno der !Eelppa"));
        assertEquals(null, obj.reverseWords(null));
        assertEquals("", obj.reverseWords(""));
        assertEquals(" ", obj.reverseWords(" "));
        assertEquals("recar racecar madam", obj.reverseWords("racer racecar madam"));
    }

    @Test
    void reverse() {
    }
}