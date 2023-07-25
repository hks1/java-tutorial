package com.examples;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BinarySearchTest {
    BinarySearch obj;

    @BeforeEach
    void setUp() {
        obj = new BinarySearch();
    }

    @Test
    @DisplayName("find number in array <= given number n")
    void searchLessOrEqual() {
        Assert.assertEquals(4, obj.searchLessOrEqual(new int[]{2,3,4,7,8,9}, 5));
        Assert.assertEquals(4, obj.searchLessOrEqual(new int[]{2,3,4,7,8,9}, 4));
        Assert.assertEquals(7, obj.searchLessOrEqual(new int[]{2,3,4,7,9,9}, 8));
    }

    @Test
    @DisplayName("find number in array <= given number n")
    void searchGreaterOrEqual() {
        Assert.assertEquals(4, obj.searchGreaterOrEqual(new int[]{2,3,4,7,8,9}, 4));
        Assert.assertEquals(7, obj.searchGreaterOrEqual(new int[]{2,3,4,7,8,9}, 6));
        Assert.assertEquals(9, obj.searchGreaterOrEqual(new int[]{2,3,4,7,9,9}, 8));
        Assert.assertEquals(9, obj.searchGreaterOrEqual(new int[]{2,3,4,7,9,9}, 9));
    }
}