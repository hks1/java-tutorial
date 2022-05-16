package com.ctci;

// 8.1
public class TripleStep {

    // memoized
    int[] memo;
    public int numWaysMemoized(int n){
        memo = new int[n+1];
        return helper(n);
    }
    public int helper(int n){
        if(n == 1 || n == 2){
            return n;
        }
        if(n == 3) {
            return 4;
        }
        if(memo[n] == 0){
            memo[n] = helper(n-1)+helper(n-2)+helper(n-3);
        }

        return memo[n];
    }

    // top-down dp
    public int numWaysDP(int n){
        int[] table = new int[n+1];
        table[0] = 1;
        for(int i = 1; i < table.length; i++){
            table[i] = table[i-1] + (i-2 >= 0 ? table[i-2] : 0) + (i-3 >= 0 ? table[i-3] : 0);
        }
        return table[n];
    }

    // recursion
    public int numWays(int n){
        if(n == 1 || n == 2) return n;
        if(n == 3) return 4;
        return numWays(n-1) + numWays(n-2) + numWays(n-3);
    }
}

class TDTripleSteps{
    public static void main(String[] args) {
        TripleStep obj = new TripleStep();
        //System.out.println(obj.numWays(10));
        final int NUM_TIMES = 40;
        long start = System.currentTimeMillis();
        for (int i = 1; i < NUM_TIMES; i++) {
            obj.numWays(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("time taken recursive: " + (end - start));
         start = System.currentTimeMillis();
        for (int i = 1; i < NUM_TIMES; i++) {
            obj.numWaysMemoized(i);
        }
         end = System.currentTimeMillis();
        System.out.println("time taken memoized: " + (end - start));
        //System.out.println("time taken: " + (end - start));
        start = System.currentTimeMillis();
        for (int i = 1; i < NUM_TIMES; i++) {
            obj.numWaysDP(i);
        }
        end = System.currentTimeMillis();
        System.out.println("time taken bottom-up DP: " + (end - start));
    }
}
