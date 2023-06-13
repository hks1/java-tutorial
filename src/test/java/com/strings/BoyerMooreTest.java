package com.strings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoyerMooreTest {

    BoyerMoore obj;

    @BeforeEach
    void setUp() {
        obj = new BoyerMoore();
    }

    @Test
    void search() {
        assertEquals(5, obj.search("Hello string", " str"));
        assertEquals(0, obj.search("Hello String", "Hello"));
        assertEquals(0, obj.search("HelloHello", "Hello"));
    }


}