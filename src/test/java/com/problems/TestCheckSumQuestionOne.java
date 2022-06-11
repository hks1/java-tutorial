package com.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestCheckSumQuestionOne {
    CheckSumQuestionOne obj;
    @BeforeEach
    public void setUp(){
        obj = new CheckSumQuestionOne();
    }
    @Test
    public void testChecksum(){
        Assertions.assertEquals(38, obj.findChecksum("5 7 8 9 \n 8 7 6 \n 4 5 6"));
        Assertions.assertEquals(38, obj.checksum("5 7 8 9 \n 8 7 6 \n 4 5 6"));
    }
}
