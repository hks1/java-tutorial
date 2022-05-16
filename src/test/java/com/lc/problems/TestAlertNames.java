package com.lc.problems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestAlertNames {
    AlertNames obj;
    @BeforeEach
    public void setUp(){
        obj = new AlertNames();
    }
    @Test
    public void testAlertNames(){
        //Example 1:
        //
        //Input: keyName = ["daniel","daniel","daniel","luis","luis","luis","luis"], keyTime = ["10:00","10:40","11:00","09:00","11:00","13:00","15:00"]
        //Output: ["daniel"]
        //Explanation: "daniel" used the keycard 3 times in a one-hour period ("10:00","10:40", "11:00").
        //Example 2:
        //
        //Input: keyName = ["alice","alice","alice","bob","bob","bob","bob"], keyTime = ["12:01","12:00","18:00","21:00","21:20","21:30","23:00"]
        //Output: ["bob"]
        //Explanation: "bob" used the keycard 3 times in a one-hour period ("21:00","21:20", "21:30").
    }
}
