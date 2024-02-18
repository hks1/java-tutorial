package com.problems.codility;

public class TapeEquilibrium {
    public int solution(int[] A) {
        // Implement your solution here
        int sum = 0;
        for(int i : A){
            sum += i;
        }
        int ans = Integer.MAX_VALUE;
        int leftsum = 0;
        int rightsum = sum;
        for(int p = 0; p < A.length; p++){
            leftsum += A[p];
            rightsum -= A[p];
            ans   = Math.min(ans, Math.abs(rightsum - leftsum));
        }
        return ans;
    }
}
