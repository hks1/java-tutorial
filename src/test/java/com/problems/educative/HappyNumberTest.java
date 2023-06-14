package com.problems.educative;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HappyNumberTest {
    HappyNumber obj;

    @BeforeEach
    void setUp() {
        obj = new HappyNumber();
    }

    @Test
    void isHappyNUmber() {
        assertTrue(obj.isHappyNUmber(1));
        assertFalse(obj.isHappyNUmber(4));
    }

    @Test
    void isHappyNumber2() {
        assertTrue(obj.isHappyNUmber(1));
        assertFalse(obj.isHappyNUmber(4));
    }
}