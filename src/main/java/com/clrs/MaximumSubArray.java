package com.clrs;

public class MaximumSubArray {
    private class Value{
        int low;
        int high;
        int sum;
        public Value(int low, int high, int sum){
            this.low = low;
            this.high = high;
            this.sum = sum;
        }
    }
    public int findMaxSubArray(int[] arr){
        int ans = 0;
        ans = find(arr, 0, arr.length-1);
        return ans;
    }

    public int find(int[] arr, int low, int high){
        if(low == high) return arr[low];
        else{
            int mid = low + (high-low)/2;
            int leftSum = find(arr, low, mid);
            int rightSum = find(arr, mid + 1, high);
            int crossSum = findMaxCrossingSubArray(arr, low, mid, high);
            if(leftSum >= crossSum && leftSum >= rightSum) return leftSum;
            else if(rightSum >= crossSum && rightSum >= leftSum) return rightSum;
            else return crossSum;
        }
    }

    public int findMaxCrossingSubArray(int[] arr, int low, int mid, int high){
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = mid; i >= 0; i--){
            sum += arr[i];
            leftSum = Math.max(leftSum, sum);
        }
        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        for(int i = mid+1; i <= high; i++){
            sum += arr[i];
            rightSum = Math.max(rightSum, sum);
        }
        return Math.max(leftSum + rightSum, Math.max(leftSum, rightSum));
    }
}
