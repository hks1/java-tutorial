package com.lc.graphs;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestGraphValidTree {
    GraphValidTree obj;
    @BeforeEach
    public void setUp(){
        obj = new GraphValidTree();
    }
    @Test
    public void testValidTree(){
        //Example 1:
        //
        //
        //Input: n = 5, edges = [[0,1],[0,2],[0,3],[1,4]]
        //Output: true
        //Example 2:
        //
        //
        //Input: n = 5, edges = [[0,1],[1,2],[2,3],[1,3],[1,4]]
        //Output: false
        Assertions.assertTrue(obj.validTree(5, new int[][]{{0,1},{0,2},{0,3},{1,4}}));
        Assertions.assertFalse(obj.validTree(5, new int[][]{{0,1},{1,2},{2,3},{1,3},{1,4}}));
    }
}
