package com.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestQuickSort {
    QuickSort obj;
    @BeforeEach
    public void setUp(){
        obj = new QuickSort();
    }
    @Test
    @DisplayName("quick sort tc 1")
    public void testQuickSortTC1(){
        int[] arr = {4,8,7,3,9,2,1};
        int[] sorted = {1,2,3,4,7,8,9};
        Assertions.assertArrayEquals(sorted, obj.quicksort(arr));
    }
}
