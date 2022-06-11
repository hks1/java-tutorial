package com.lc.graphs;

import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfIslands {
    //200. Number of Islands
    //Medium
    //
    //13609
    //
    //322
    //
    //Add to List
    //
    //Share
    //Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
    //
    //An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
    public int numIslands(char[][] grid){
        int numOfIslands = 0;
        int[][] visited = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1' && visited[i][j] == 0){
                    bfs(grid, visited, i, j);
                    numOfIslands++;
                }
            }
        }
        return numOfIslands;
    }

    class Coordinate{
        int row;
        int col;
        public Coordinate(int r, int c){
            this.row = r;
            this.col = c;
        }
    }
    public void bfs(char[][] grid, int[][] visited, int row, int col){
        Queue<Coordinate> queue = new ArrayDeque<>();
        queue.add(new Coordinate(row,col));
        visited[row][col] = 1;
        int[][] dim = {{-1,0}, {1,0}, {0,-1},{0,1}};
        while(queue.size() > 0){
            Coordinate temp = queue.poll();
            for(int counter = 0; counter < dim.length; counter++){
                int r = temp.row + dim[counter][0];
                int c = temp.col + dim[counter][1];
                if(r >= 0 && r < grid.length && c >= 0 && c < grid[r].length && visited[r][c] == 0 && grid[r][c] == '1'){
                    visited[r][c] = 1;
                    queue.add(new Coordinate(r,c));
                }
            }
        }
    }
}
