package com.lc.problems;

import java.util.HashSet;
import java.util.Set;

// 36. Valid Sudoku
//Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
//
//Each row must contain the digits 1-9 without repetition.
//Each column must contain the digits 1-9 without repetition.
//Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
//Note:
//
//A Sudoku board (partially filled) could be valid but is not necessarily solvable.
//Only the filled cells need to be validated according to the mentioned rules.

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board){
        // validate rows
        for(int i = 0; i < board.length; i++){
            if(validateRow(board, i) == false){
                return false;
            }
        }
        // validate columns
        for(int i = 0; i < board[0].length; i++){
            if(validateCol(board, i) == false){
                return false;
            }
        }
        // validate sub matrices
        for(int i = 0; i < board.length; i = i + 3){
            for(int j = 0; j < board[i].length; j = j + 3){
                if(validateSubMatrix(board, i, j) == false){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean validateRow(char[][] board, int row){
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < board[row].length; i++){
            char c = board[row][i];
            if(c >= '1' && c <= '9' && set.contains(c)){
                return false;
            }else{
                set.add(c);
            }
        }
        return true;
    }

    public boolean validateCol(char[][] board, int col){
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < board.length; i++){
            char c = board[i][col];
            if(c >= '1' && c <= '9' && set.contains(c)){
                return false;
            }else{
                set.add(c);
            }
        }
        return true;
    }

    /**
     * validate 3x3 sub matrix starting at index (i,j)
     * @param board
     * @param i
     * @param j
     * @return
     */
    public boolean validateSubMatrix(char[][] board, int row, int col){
        Set<Character> set = new HashSet<>();
        for(int i = row; i < row+3; i++){
            for(int j = col; j < col+3; j++){
                char c = board[i][j];
                if(c >= '1' && c <= '9' && set.contains(c)){
                    return false;
                }else{
                    set.add(c);
                }
            }
        }
        return true;
    }
}
