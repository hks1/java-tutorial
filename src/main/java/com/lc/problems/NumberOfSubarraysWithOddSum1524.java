package com.lc.problems;

import java.util.HashMap;
import java.util.Map;

public class NumberOfSubarraysWithOddSum1524 {
    /*
    public int numOfSubarrays(int[] arr) {
        Map<String, Integer> map = new HashMap<>();
        map.put("even",1);
        map.put("odd", 0);
        int prefixsum = 0;
        int total = 0;
        for(int i = 0; i < arr.length; i++){
            prefixsum += arr[i];
            if(prefixsum % 2 == 0){
                total += map.get("odd");
            } else{
                total += map.get("even");
            }
            // update map
            if(prefixsum % 2 == 0){
                map.put("even", map.get("even") + 1);
            } else{
                map.put("odd", map.get("odd") + 1);
            }
        }
        return total;
    }

     */
}
