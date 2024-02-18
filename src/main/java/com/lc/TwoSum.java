package com.lc;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] A, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            map.put(A[i], i);
        }
        for (int i = 0; i < A.length; i++) {
            int var = target - A[i];
            if (map.containsKey(var) && map.get(var) != i){
                return new int[]{i, map.get(var)};
            }
        }
        return new int[]{-1,-1};
    }
}
