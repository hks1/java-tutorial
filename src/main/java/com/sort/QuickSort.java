package com.sort;

public class QuickSort {
    public int[] quicksort(int[] arr){
        helper(arr, 0, arr.length-1);
        return arr;
    }
    public void helper(int[] arr, int start, int end){
        if(start >= end) return;
        int pivot = start;
        for(int i = 1; i <= end; i++){
            if(arr[i] < arr[pivot]){
                swap(arr, i, ++start);
            }
        }
        swap(arr, start, pivot);
        helper(arr, start, pivot-1);
        helper(arr, pivot+1, end);
    }
    public void swap(int[] a, int i, int j){
        if(i == j) return;
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
