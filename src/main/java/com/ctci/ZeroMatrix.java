package com.ctci;

/**
 * 1.8
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.
 */
public class ZeroMatrix {
    public int[][] zeroMatrix(int[][] mat){
        int m = mat.length;
        int n = mat[0].length;
        // initialize arrays to keep track of rows and cols to be set zero
        int[] row = new int[m];
        int[] col = new int[n];
        // populate arrays to keep track of rows and cols to be set zero
        for(int i =0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        for(int i =0; i < m; i++){
            for (int j = 0; j < n; j++){
                if(row[i] == 1 || col[j] == 1){
                    mat[i][j] = 0;
                }
            }
        }
        return mat;
    }
}
