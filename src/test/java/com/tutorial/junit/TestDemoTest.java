package com.tutorial.junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestDemoTest {

    TestDemo divideMethod = new TestDemo();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void divide() {
    }

    @Test
    public void testDivideByZero(){
        assertEquals(2, divideMethod.divide(10, 5));
        assertThrows(ArithmeticException.class, () -> divideMethod.divide(100, 0));
    }
}