package com.lc.graphs;

import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestIsGraphBipartite {
    IsGraphBipartite obj;
    @Before
    public void setUp(){
        obj = new IsGraphBipartite();
    }
    @Test
    public void testIsBipartite(){
        //Example 1:
        //
        //
        //Input: graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
        //Output: false
        //Explanation: There is no way to partition the nodes into two independent sets such that every edge connects a node in one and a node in the other.
        //Example 2:
        //
        //
        //Input: graph = [[1,3],[0,2],[1,3],[0,2]]
        //Output: true
        //Explanation: We can partition the nodes into two sets: {0, 2} and {1, 3}.
        Assertions.assertFalse(obj.isBipartite(new int[][] {{1,2,3},{0,2},{0,1,3},{0,2}}));
        Assertions.assertTrue(obj.isBipartite(new int[][] {{1,3},{0,2},{1,3},{0,2}}));
    }
}
