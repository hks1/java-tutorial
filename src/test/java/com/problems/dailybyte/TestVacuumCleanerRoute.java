package com.problems.dailybyte;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestVacuumCleanerRoute {
    VacuumCleanerRoute obj;
    @BeforeEach
    public void setUp(){
        obj = new VacuumCleanerRoute();
    }

    @Test
    public void testReturnToOrigPos(){
        Assertions.assertTrue(obj.returnToOrigPos("RUULLDRD"));
        Assertions.assertFalse(obj.returnToOrigPos("URURD"));
    }
}
