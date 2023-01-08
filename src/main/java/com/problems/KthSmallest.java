package com.problems;

public class KthSmallest {
    public int partition(int[] nums, int start, int end){
        int pivot = (int) ((Math.random() * (end - start)) + start);
        swap(nums, pivot, start);
        int left = start;
        for(int i = start + 1; i <= end; i++){
            if(nums[i] < nums[start]){
                swap(nums, i, ++left);
            }
        }
        swap(nums, start, left);
        return left;
    }

    public int kthSmallest(int[] nums, int start, int end, int k){
        // find the partition
        int partition = partition(nums, start, end);

        if(partition == k-1){
            return nums[partition];
        }

        if(partition < k - 1){
            return kthSmallest(nums, partition + 1, end, k);
        } else{
            return kthSmallest(nums, start, partition - 1, k);
        }
    }

    public void swap(int[] nums, int i, int j){
        if (i == j) return;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
