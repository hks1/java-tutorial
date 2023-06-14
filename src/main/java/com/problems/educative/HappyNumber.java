package com.problems.educative;

import com.utils.Utils;

import java.util.HashSet;

public class HappyNumber {
    public boolean isHappyNUmber(int n){
        HashSet<Integer> set = new HashSet<>();
        while(n != 1){
            n = Utils.sumOfSquaredDigits(n);
            if(set.contains(n)){
                return false;
            }
            set.add(n);
        }
       return true;
    }

    public boolean isHappyNumber2(int n){
        int slow = n;
        int fast = Utils.sumOfSquaredDigits(n);
        while(fast != slow){
            slow = Utils.sumOfSquaredDigits(slow);
            fast = Utils.sumOfSquaredDigits(Utils.sumOfSquaredDigits(fast));
            if(fast == 1){
                return true;
            }
        }
        return false;
    }
}
