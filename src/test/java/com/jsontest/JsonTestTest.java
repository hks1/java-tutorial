package com.jsontest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JsonTestTest {

    JsonTest obj;

    @BeforeEach
    void setUp() {
        obj = new JsonTest();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void printXmlFromJson() {
        String jsonStr = "{student : { age:30, name : Kumar, technology : Java } }";
        obj.printXmlFromJson(jsonStr);
    }
}