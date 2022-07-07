package com.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestProblemSetOne {
    ProblemSetOne obj;
    @BeforeEach
    public void setUp(){
        obj = new ProblemSetOne();
    }
    @Test
    public void testFindRowsAndCols(){
        //Sample inputs:
        //board1 =
        //{{'+', '+', '+', '0', '+', '0', '0'},
        //{'0', '0', '0', '0', '0', '0', '0'},
        //{'0', '0', '+', '0', '0', '0', '0'},
        //{'0', '0', '0', '0', '+', '0', '0'},
        //{'+', '+', '+', '0', '0', '0', '+'}}
        //Expected output = [[1], [3, 5]]
        //
        //board2 =
        //{{'+', '+', '+', '0', '+', '0', '0'},
        //{'0', '0', '0', '0', '0', '+', '0'},
        //{'0', '0', '+', '0', '0', '0', '0'},
        //{'0', '0', '0', '0', '+', '0', '0'},
        //{'+', '+', '+', '0', '0', '0', '+'}}
        //Expected output = [[], [4]]
        //
        //board3 =
        //{{'+', '+', '+', '0', '+', '0', '0'},
        //{'0', '0', '0', '0', '0', '0', '0'},
        //{'0', '0', '+', '+', '0', '+', '0'},
        //{'0', '0', '0', '0', '+', '0', '0'},
        //{'+', '+', '+', '0', '0', '0', '+'}}
        //Expected output = [[1], []]
        //
        //board4 = {{'+'}}
        //Expected output = [[], []]
        char[][] board =
                {
                        {'+','+','+','+','+','+','+','0','0'},
                {'+','+','0','0','0','0','0','+','+'},
                {'0','0','0','0','0','+','+','0','+'},
                {'+','+','0','+','+','+','+','0','0'},
                {'+','+','0','0','0','0','0','0','+'},
                        {'+','+','0','+','+','0','+','0','+'}
                };
        char[][] board1 =
                {
                        {'+', '+', '+', '0', '+', '0', '0'},
                        {'0', '0', '0', '0', '0', '0', '0'},
                        {'0', '0', '+', '0', '0', '0', '0'},
                        {'0', '0', '0', '0', '+', '0', '0'},
                        {'+', '+', '+', '0', '0', '0', '+'}
                };
        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.asList(1));
        result.add(Arrays.asList(3,5));
        Assertions.assertEquals(result, obj.findRowsAndCols(board1));
    }
    @Test
    public void testFindNearestExit(){
        //Sample inputs:
        //board1 = [['+', '+', '+', '+', '+', '+', '+', '0', '0'],
        //['+', '+', '0', '0', '0', '0', '0', '+', '+'],
        //['0', '0', '0', '0', '0', '+', '+', '0', '+'],
        //['+', '+', '0', '+', '+', '+', '+', '0', '0'],
        //['+', '+', '0', '0', '0', '0', '0', '0', '+'],
        //['+', '+', '0', '+', '+', '0', '+', '0', '+']]
        //start1_1 = (2, 0) # Expected output = (5, 2)
        //start1_2 = (0, 7) # Expected output = (0, 8)
        //start1_3 = (5, 2) # Expected output = (2, 0) or (5, 5)
        //start1_4 = (5, 5) # Expected output = (5, 7)
        //
        //board2 = [['+', '+', '+', '+', '+', '+', '+'],
        //['0', '0', '0', '0', '+', '0', '+'],
        //['+', '0', '+', '0', '+', '0', '0'],
        //['+', '0', '0', '0', '+', '+', '+'],
        //['+', '+', '+', '+', '+', '+', '+']]
        //start2_1 = (1, 0) # Expected output = null (or a special value representing no possible exit)
        //start2_2 = (2, 6) # Expected output = null
        //
        //board3 = [['+', '0', '+', '0', '+',],
        //['0', '0', '+', '0', '0',],
        //['+', '0', '+', '0', '+',],
        //['0', '0', '+', '0', '0',],
        //['+', '0', '+', '0', '+']]
        //start3_1 = (0, 1) # Expected output = (1, 0)
        //start3_2 = (4, 1) # Expected output = (3, 0)
        //start3_3 = (0, 3) # Expected output = (1, 4)
        //start3_4 = (4, 3) # Expected output = (3, 4)
        //
        //board4 = [['+', '0', '+', '0', '+',],
        //['0', '0', '0', '0', '0',],
        //['+', '+', '+', '+', '+',],
        //['0', '0', '0', '0', '0',],
        //['+', '0', '+', '0', '+']]
        //start4_1 = (1, 0) # Expected output = (0, 1)
        //start4_2 = (1, 4) # Expected output = (0, 3)
        //start4_3 = (3, 0) # Expected output = (4, 1)
        //start4_4 = (3, 4) # Expected output = (4, 3)
        //
        //board5 = [['+', '0', '0', '0', '+',],
        //['+', '0', '+', '0', '+',],
        //['+', '0', '0', '0', '+',],
        //['+', '0', '+', '0', '+']]
        //start5_1 = (0, 1) # Expected output = (0, 2)
        //start5_2 = (3, 1) # Expected output = (0, 1)
        //
        //All test cases:
        //findExit(board1, start1_1) => (5, 2)
        //findExit(board1, start1_2) => (0, 8)
        //findExit(board1, start1_3) => (2, 0) or (5, 5)
        //findExit(board1, start1_4) => (5, 7)
        //findExit(board2, start2_1) => null (or a special value representing no possible exit)
        //findExit(board2, start2_2) => null
        //findExit(board3, start3_1) => (1, 0)
        //findExit(board3, start3_2) => (3, 0)
        //findExit(board3, start3_3) => (1, 4)
        //findExit(board3, start3_4) => (3, 4)
        //findExit(board4, start4_1) => (0, 1)
        //findExit(board4, start4_2) => (0, 3)
        //findExit(board4, start4_3) => (4, 1)
        //findExit(board4, start4_4) => (4, 3)
        //findExit(board5, start5_1) => (0, 2)
        //findExit(board5, start5_2) => (0, 1)
        //
        //Complexity Analysis:
        //
        //r: number of rows in the board
        //c: number of columns in the board
        char[][] board1 = {
                {'+', '+', '+', '+', '+', '+', '+', '0', '0'},
                {'+', '+', '0', '0', '0', '0', '0', '+', '+'},
                {'0', '0', '0', '0', '0', '+', '+', '0', '+'},
                {'+', '+', '0', '+', '+', '+', '+', '0', '0'},
                {'+', '+', '0', '0', '0', '0', '0', '0', '+'},
                {'+', '+', '0', '+', '+', '0', '+', '0', '+'}
                };
        Assertions.assertArrayEquals(new int[]{5,2}, obj.findNearestExit(board1, 2, 0));
    }
}
