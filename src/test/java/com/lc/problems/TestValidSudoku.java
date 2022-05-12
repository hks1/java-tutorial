package com.lc.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestValidSudoku {
    ValidSudoku obj;
    char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'},
    };
    char[][] board1 = {
            {'8','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'},
    };
    @BeforeEach
    public void setUP(){
        obj = new ValidSudoku();
    }
    @Test
    public void testIsValidSudoku(){

        Assertions.assertTrue(obj.isValidSudoku(board));
        Assertions.assertFalse(obj.isValidSudoku(board1));
    }
    @Test
    public void testIsValidSudokuWithHashSet(){
        Assertions.assertTrue(obj.isValidSudokuWithHashSet(this.board));
        Assertions.assertFalse(obj.isValidSudokuWithHashSet(board1));
    }
}
