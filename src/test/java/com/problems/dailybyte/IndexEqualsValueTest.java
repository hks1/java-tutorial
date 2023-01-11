package com.problems.dailybyte;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class IndexEqualsValueTest {
    IndexEqualsValue obj;

    @BeforeEach
    void setUp() {
        obj = new IndexEqualsValue();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void indexEqualsValue() {
        int[] bigArray = new int[10000];
        Arrays.fill(bigArray,10000);
        int[] bigArray1 = new int[10000];
        Arrays.fill(bigArray1,9999);
        Assertions.assertEquals(0, obj.indexEqualsValue(new int[]{0, 4, 8}));
        Assertions.assertEquals(-1, obj.indexEqualsValue(new int[]{1, 3, 7, 12}));
        Assertions.assertEquals(5, obj.indexEqualsValue(new int[]{-1,0,1,2,3,5,6,7}));
        Assertions.assertEquals(-1, obj.indexEqualsValue(bigArray));
        Assertions.assertEquals(9999, obj.indexEqualsValue(bigArray1));

    }
}