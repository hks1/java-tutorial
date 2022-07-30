package com.problems;

import java.util.*;
// Indeed
//https://leetcode.com/discuss/interview-question/1970191/Indeed-or-Sr.-SDE-or-karat-Interview
public class ProblemSetOne {
    //We have a two-dimensional board game involving snakes. The board has two types of squares on it: +'s represent impassable squares where snakes cannot go, and 0's represent squares through which snakes can move.
    //
    //Here is an example board:
    //
    //col-->        0  1  2  3  4  5  6  7  8
    //           +---------------------------
    //row      0 |  +  +  +  +  +  +  +  0  0
    // |       1 |  +  +  0  0  0  0  0  +  +
    // |       2 |  0  0  0  0  0  +  +  0  +c
    // v       3 |  +  +  0  +  +  +  +  0  0
    //         4 |  +  +  0  0  0  0  0  0  +
    //         5 |  +  +  0  +  +  0  +  0  +
    //Find the rows and columns in which the snake can move free freely.
    public List<List<Integer>> findRowsAndCols(char[][] board){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> listOfRows = new ArrayList<>();
        List<Integer> listOfCols = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            boolean isMoveValid = true;
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j] == '+'){
                    isMoveValid = false;
                }
            }
            if(isMoveValid){
                listOfRows.add(i);
            }
        }
        for (int i = 0; i < board[0].length; i++) {
            boolean isMoveValid = true;
            for (int j = 0; j < board.length; j++) {
                if(board[j][i] == '+'){
                    isMoveValid = false;
                }
            }
            if(isMoveValid){
                listOfCols.add(i);
            }
        }
        result.add(listOfRows);
        result.add(listOfCols);
        return result;
    }

    //We have a two-dimensional board game involving snakes. The board has two types of squares on it: +'s represent impassable squares where snakes cannot go, and 0's represent squares through which snakes can move.
    //
    //Snakes may move in any of four directions - up, down, left, or right - one square at a time, but they will never return to a square that they've already visited. If a snake enters the board on an edge square, we want to catch it at a different exit square on the board's edge.
    //
    //The snake is familiar with the board and will take the route to the nearest reachable exit, in terms of the number of squares it has to move through to get there. Note that there may not be a reachable exit.
    //Here is an example board:
    //
    //col-->        0  1  2  3  4  5  6  7  8
    //           +---------------------------
    //row      0 |  +  +  +  +  +  +  +  0  0
    // |       1 |  +  +  0  0  0  0  0  +  +
    // |       2 |  0  0  0  0  0  +  +  0  +
    // v       3 |  +  +  0  +  +  +  +  0  0
    //         4 |  +  +  0  0  0  0  0  0  +
    //         5 |  +  +  0  +  +  0  +  0  +
    //Write a function that takes a rectangular board with only +'s and O's, along with a starting point on the edge of the board, and returns the coordinates of the nearest exit to which it can travel. If there is a tie, return any of the nearest exits.
    public int[] findNearestExit(char[][] board, int r, int c){
        int[][] offsets = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
        int ROWS = board.length;
        int COLS = board[0].length;
        boolean[][] visited = new boolean[ROWS][COLS];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r,c});
        while (q.size() > 0){
            int[] pair = q.poll();
            visited[pair[0]][pair[1]] = true;
            //System.out.println(Arrays.toString(pair) + " " + Arrays.deepToString(visited));
            for(int i = 0; i < offsets.length; i++){
                int row = pair[0] + offsets[i][0];
                int col = pair[1] + offsets[i][1];
                if((row != r || col != c) && (row == 0 || row == board.length-1 || col == 0 || col == board[0].length-1) && board[row][col] == '0'){
                    //System.out.println("return: " + row + " " + col);
                    return new int[]{row, col};
                }
                //System.out.println(row + " " + col + " " + visited[row][col]);
                if(row >= 0 && row < board.length && col >= 0 && col < board[row].length && !visited[row][col] && board[row][col] == '0'){
                    //System.out.println("::" + row + " " + col);

                    q.add(new int[]{row,col});

                }
            }
        }
        return new int[]{-1,-1};
    }
}
