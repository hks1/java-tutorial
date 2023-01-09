package com.problems.patterns.slidingwindow;

import java.util.Arrays;

public class AvgOfSubarrayOfSizeK {
    public double[] findAverages(int[] arr, int k){
        if(k > arr.length) return null;
        double[] avgs = new double[arr.length - k + 1];
        int left = 0;
        int sum = 0;
        for(int i = 0; i < k-1 ; i++){
            sum += arr[i];
        }
        int avgsIdx = 0;
        for(int i = k-1; i < arr.length; i++){
            sum += arr[i];
            avgs[avgsIdx++] = sum / (k * 1.0);
            sum -= arr[left++];

        }
        System.out.println(Arrays.toString(avgs));
        return avgs;
    }
}
