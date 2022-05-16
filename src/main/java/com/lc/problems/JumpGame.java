package com.lc.problems;

public class JumpGame {
    //45. Jump Game II
    //Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
    //
    //Each element in the array represents your maximum jump length at that position.
    //
    //Your goal is to reach the last index in the minimum number of jumps.
    //
    //You can assume that you can always reach the last index.
    public int jump(int[] nums) {
        int res = 0;
        int l = 0;
        int r = 0;
        while(r < nums.length-1){
            int farthest = 0;
            for(int i = l; i < r+1; i++){
                farthest = Math.max(farthest, i + nums[i]);
            }
            l = r + 1;
            r = farthest;
            res += 1;
        }
        return res;
    }
}
