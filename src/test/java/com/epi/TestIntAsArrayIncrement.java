package com.epi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestIntAsArrayIncrement {
    IntAsArrayIncrement obj;
    @BeforeEach
    public void setUp(){
        obj = new IntAsArrayIncrement();
    }
    @Test
    @DisplayName("test case 1")
    public void testIntAsArrayIncrementTC1(){
        List<Integer> list1 = Arrays.asList(3,4,5);
        List<Integer> list2 = new ArrayList<>();
        list2.addAll(Arrays.asList(9,9,9,9));
        Assertions.assertEquals(Arrays.asList(3,4,6), obj.plusOne(list1));
        Assertions.assertEquals(Arrays.asList(1,3,5,0), obj.plusOne(Arrays.asList(1,3,4,9)));
        Assertions.assertEquals(Arrays.asList(1,0,0,0,0), obj.plusOne(list2));
    }
}
