package com.problems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestProblemSetTwo {
    ProblemSetTwo obj;
    @BeforeEach
    public void setUp(){
        obj = new ProblemSetTwo();
    }
    @Test
    public void testGetHighestNumOfAccesses(){
        //Example:
        //logs1 = [
        //["58523", "user_1", "resource_1"],
        //["62314", "user_2", "resource_2"],
        //["54001", "user_1", "resource_3"],
        //["200", "user_6", "resource_5"],
        //["215", "user_6", "resource_4"],
        //["54060", "user_2", "resource_3"],
        //["53760", "user_3", "resource_3"],
        //["58522", "user_22", "resource_1"],
        //["53651", "user_5", "resource_3"],
        //["2", "user_6", "resource_1"],
        //["100", "user_6", "resource_6"],
        //["400", "user_7", "resource_2"],
        //["100", "user_8", "resource_6"],
        //["54359", "user_1", "resource_3"],
        //]
        //
        //Example 2:
        //logs2 = [
        //["300", "user_1", "resource_3"],
        //["599", "user_1", "resource_3"],
        //["900", "user_1", "resource_3"],
        //["1199", "user_1", "resource_3"],
        //["1200", "user_1", "resource_3"],
        //["1201", "user_1", "resource_3"],
        //["1202", "user_1", "resource_3"]
        //]
        //
        //Example 3:
        //logs3 = [
        //["300", "user_10", "resource_5"]
        //]
        //Expected Output:
        //most_requested_resource(logs1) # => ('resource_3', 3)
        //Reason: resource_3 is accessed at 53760, 54001, and 54060
        //
        //most_requested_resource(logs2) # => ('resource_3', 4)
        //Reason: resource_3 is accessed at 1199, 1200, 1201, and 1202
        //
        //most_requested_resource(logs3) # => ('resource_5', 1)
        //Reason: resource_5 is accessed at 300
        //
        //Complexity analysis variables:
        //
        //n: number of logs in the input
    }
}
