package com.problems.codility;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TapeEquilibriumTest {
    TapeEquilibrium obj;

    @BeforeEach
    void setUp() {
        obj = new TapeEquilibrium();
    }

    @Test
    void solution() {
        Assertions.assertEquals(2, obj.solution(new int[]{2,4, 7}));
    }
}