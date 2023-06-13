package com.tutorial.lil;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataTest {

    Data data;

    @BeforeEach
    void setUp() {
        data = new Data();
    }

    @Test
    void return5() {
        assertEquals(5, data.return5());
    }

    @Test
    void isUpperCaseString() {
        assertTrue(data.isUpperCaseString("ABC"));
        assertFalse(data.isUpperCaseString("aBC"));
        assertFalse(data.isUpperCaseString("ABc"));
    }

    @Test
    void isLowerCaseString(){
        assertTrue(data.isLowerCaseString("abcdefgt"));
        assertFalse(data.isLowerCaseString("abcFgt"));

    }

    @Test
    void isPasswordComplex() {
        assertTrue(data.isPasswordComplex("Hell0"));
        assertFalse(data.isPasswordComplex("Hello"));
        assertFalse(data.isPasswordComplex("hello"));
        assertFalse(data.isPasswordComplex("HELLO"));
        assertFalse(data.isPasswordComplex("hell0"));
        assertFalse(data.isPasswordComplex("HELL0"));
    }
}