package com.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.OptionalInt;

import static org.junit.jupiter.api.Assertions.*;

class SearchTest {

    Search obj;

    @BeforeEach
    void setUp() {
        obj = new Search();
    }

    @Test
    void linearSearch() {
        int[] arr = {1,2,3,4,5,6};
        int result = obj.linearSearch(arr, 1).getAsInt();

        assertEquals(1, obj.linearSearch(new int[] {1,2,3,4,5}, 1).getAsInt());
        assertEquals(OptionalInt.of(1), obj.linearSearch(new int[] {1,2,3,4,5}, 1));
        assertEquals(OptionalInt.empty(), obj.linearSearch(new int[]{1,2,3,4,5}, 6));
    }

    @Test
    void binarySearch() {

        assertEquals(OptionalInt.of(1), obj.binarySearch(new int[]{0,2,4,5,6,8}, 2));
        assertEquals(OptionalInt.empty(), obj.binarySearch(new int[]{0,2,4,5,6,8}, 9));
    }
}