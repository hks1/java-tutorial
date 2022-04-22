package com.epi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class AddBinaryAsArrays {
    BiFunction<Integer, Integer, Integer> addBinary = (x1, x2) -> x1+x2;
    public List<Integer> addBinary(int[] s, int[] t){
        List<Integer> result = new ArrayList<>();
        int i = s.length-1;
        int j = t.length-1;
        while( i >= 0 && j >= 0){
            result.add(s[i] + t[j]);
            i--;
            j--;
        }
        while(i >= 0){
            result.add(s[i]);
            i--;
        }
        while(j >= 0){
            result.add(t[j]);
            j--;
        }
        for(int k = 0; k < result.size()-1; k++){
            if(result.get(k) == 2){
                result.set(k, 0);
                result.set(k+1, result.get(k+1) + 1);
            }
            if(result.get(k) == 3){
                result.set(k, 1);
                result.set(k+1, result.get(k+1) + 1);
            }
        }
        if(result.get(result.size()-1) == 2){
            result.set(result.size()-1, 0);
            result.add(1);
        }
        if(result.get(result.size()-1) == 3){
            result.set(result.size()-1, 1);
            result.add(1);
        }
        Collections.reverse(result);
        return result;
    }
}
