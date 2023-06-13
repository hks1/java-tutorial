package com.tutorial.generics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GenericMethodExamples1Test {

    @BeforeEach
    void setUp() {
    }

    @Test
    void fromArrayToList() {
    }

    @Test
    void testFromArrayToList() {
    }

    @Test
    public void givenArrayOfIntegers_thanListOfStringReturnedOK() {
        Integer[] intArray = {1, 2, 3, 4, 5};
        List<String> stringList
                = Generics.fromArrayToList(intArray, Object::toString);

        assertThat(stringList, hasItems("1", "2", "3", "4", "5"));
    }
}