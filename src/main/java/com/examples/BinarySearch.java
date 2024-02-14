package com.examples;

public class BinarySearch {

    public int searchLessOrEqual(int[] numbers, int number){
        int lo = 0;
        int hi = numbers.length-1;
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            if(numbers[mid] <= number){
                lo = mid;
            }else{
                hi = mid - 1;
            }
        }
        return numbers[lo];
    }

    public int searchGreaterOrEqual(int[] numbers , int number){
        int lo = 0;
        int hi = numbers.length - 1;
        while (lo < hi){
            int mid = lo + (hi - lo) / 2;
            if(numbers[mid] >= number){
                hi = mid;
            }else{
                lo = mid + 1;
            }
        }
        return numbers[hi];
    }
}
