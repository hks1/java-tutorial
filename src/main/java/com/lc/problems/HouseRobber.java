package com.lc.problems;

public class HouseRobber {
    public int rob(int[] nums){
        if(nums.length == 1) return nums[0];
        int[] dpTable = new int[nums.length];
        dpTable[0] = nums[0];
        dpTable[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++){
            dpTable[i] = Math.max(dpTable[i-1], dpTable[i-2] + nums[i]);
        }
        return dpTable[dpTable.length - 1];
    }
}

class  TDHouseRobber{
    public static void main(String[] args) {
        HouseRobber robber = new HouseRobber();
        System.out.println(robber.rob(new int[]{1,2,3,1}));
        System.out.println(robber.rob(new int[]{2,7,9,3,1}));
    }
}
