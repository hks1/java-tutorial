package com.lc.problems;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, 0, new ArrayList<Integer>(), result);
        return result;
    }

    public void helper(int[] nums, int index, ArrayList<Integer> slate, List<List<Integer>> result){
        if(index == nums.length){
            result.add(new ArrayList<Integer>(slate));
        } else {
            // exclude
            helper(nums, index+1, slate, result);
            // include
            slate.add(nums[index]);
            helper(nums, index+1, slate, result);
            slate.remove(slate.size()-1);
        }
    }
}

