package com.lc.problems;

public class FindKthSmallestElementInTwoSortedArrays {
    public int findKthSmallestElementInTwoSortedArrays(int[] a1, int[] a2, int k){
        int start = 0;
        int end = a1.length - 1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if((k-mid-1 > 0 ? a2[k-mid-1-1] : Integer.MIN_VALUE) <= a1[mid] && a1[mid] <= (k-mid-1 < a2.length ? a2[k-mid-1] : Integer.MAX_VALUE)){
                return a1[mid];
            } else if((k-mid > 0 ? a2[k-mid-1] : Integer.MIN_VALUE) < a1[mid]){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return a2[k-1-start];
    }

    public int findMedianSortedArrays(int[] a1, int[] a2){
        int m = a1.length;
        int n = a2.length;
        int k = (m+n)/2;
        findKthSmallestElementInTwoSortedArrays(a1, a2, k+1);
        int start = 0;
        int end = a1.length - 1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if((k-mid-1 > 0 ? a2[k-mid-1-1] : Integer.MIN_VALUE) <= a1[mid] && a1[mid] <= a2[k-mid-1]){
                if((m+n)%2 != 0){
                    return a1[mid];
                } else {
                    return (a1[mid] + Math.min(a1[mid+1], a2[k-mid-1])) / 2;
                }
            } else if((k-mid > 0 ? a2[k-mid-1] : Integer.MIN_VALUE) < a1[mid]){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if(m+n % 2 != 0){
            return a2[k-1-start];
        } else {
            return (a2[k-1-start] + Math.min(a1[start], a2[k-start])) / 2;
        }

    }

}

class TestDriveKthSmallest{
    public static void main(String[] args) {
        FindKthSmallestElementInTwoSortedArrays obj = new FindKthSmallestElementInTwoSortedArrays();
        //int[] a1 = new int[] {1,2,3,4,5,7};
        int[] a1 = new int[] {1,2,3,4,5,6};
        //int[] a2 = new int[] {11,12,13,14,15,16};
        int[] a2 = new int[] {7,12,13,14,15,16};
        //System.out.println(obj.findKthSmallestElementInTwoSortedArrays(a1, a2, 7));

        System.out.println(obj.findMedianSortedArrays(new int[]{1,3}, new int[]{2}));
    }
}
