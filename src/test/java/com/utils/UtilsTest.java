package com.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    Utils obj;

    @BeforeEach
    void setUp() {
        obj = new Utils();
    }

    @Test
    void isPalindrome() {
    }

    @Test
    void toBase64() {
    }

    @Test
    void swap() {
    }

    @Test
    void listToArray() {
    }

    @Test
    void listToIntArray() {
    }

    @Test
    void padRight() {
    }

    @Test
    void padLeft() {
    }

    @Test
    void sumOfSquaredDigits() {
        assertEquals(17, obj.sumOfSquaredDigits(14));
        assertEquals(1, obj.sumOfSquaredDigits(1));
        assertEquals(14, obj.sumOfSquaredDigits(231));
        assertEquals(145, obj.sumOfSquaredDigits(89));
        assertEquals(16, Utils.sumOfSquaredDigits(4));
    }
}