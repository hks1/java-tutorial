package com.problems;

import java.util.Arrays;

public class RangeMinimumQuery {

    int[] segment;
    int N; // length of original nums array

    public RangeMinimumQuery(int[] nums){

        // time to build the tree O(n)

        N = nums.length;
        int n = 1;
        while(n < nums.length){
            n *= 2;
        }

        segment = new int[2*n];

        Arrays.fill(segment, Integer.MAX_VALUE);

        for(int i = 0; i < N; i++){
            segment[N + i] = nums[i];
        }

        for(int i = N -1; i > 0; i--){
            segment[i] = Math.min(segment[2*i], segment[2*i+1]);
        }

    }


    public void update(int index, int val){

        // T(update) = O(logn)
        segment[N +index] = val; // leaf node updated
        /// update the internal node
        int p = (N +index) / 2;
        while (p != 0){
            segment[p] = Math.min(segment[2*p], segment[2*p+1]);
            p = p/2;
        }
    }

    public int rangeMinQuery(int i, int j){
        return helper(1, 1, N, i+1, j+1);
    }

    public int helper(int index, int l, int r, int ql, int qr){
        // base case - leaf node
        if(l == r){ // subarray of size 1
            if(ql <= l && l <= qr){
                return segment[index];
            }else{
                return Integer.MAX_VALUE;
            }
        }

        // recursive
        if(ql <= l && l <= r && r <= qr){
            return segment[index];
        }else if(qr < l || r < ql){ // no overlap
            return Integer.MAX_VALUE;
        }else{ // delegate
            int mid = (l + r) / 2;
            return Math.min(helper(2 * index, l, mid, ql, qr),
                    helper(2 * index + 1, mid + 1, r, ql, qr));
        }

    }

    public int rangeMinQueryIterative(int i, int j){
        int L = N + i; // leftmost leaf in the segment tree
        int R = N + j; // rightmost leaf in the segment tree
        int ans = Integer.MAX_VALUE;
        while(L <= R){
            if(L % 2 == 1){ //L is odd, right child
                ans = Math.min(ans, segment[L]);
                L = L/2 + 1;
            }else{
                L = L/2;
            }
            if(R %2 == 0){
                ans = Math.min(ans, segment[R]);
                R = R/2 - 1;
            }else{
                R = R/2;
            }
        }
        return ans;
    }

    //...
    public void constructTree(int[] input, int[] segTree, int low, int high, int position){
        if(low == high){
            segTree[position] = input[low];
            return;
        }

        int mid = (low + high) / 2;

        constructTree(input, segTree, mid + 1, high, 2*position + 1);
        constructTree(input, segTree, mid + 1, high, 2*position + 2);

        segTree[position] = Math.min(segTree[2*position + 1], segTree[2*position + 2]);

    }

    public int rangeMinQuery(int[] segmentTree, int qlow, int qhigh, int low, int high, int pos){
        if(qlow <= low && qhigh >= high){
            return segmentTree[pos];
        }
        if(qlow > high || qhigh < low){
            return Integer.MAX_VALUE;
        }
        int mid = (low + high) / 2;

        return Math.min(rangeMinQuery(segmentTree, qlow, qhigh, low, mid, 2*pos + 1),
                rangeMinQuery(segmentTree, qlow, qhigh, mid + 1, high, 2*pos + 2));
    }
}

class TDRSQ{
    public static void main(String[] args) {
        RangeMinimumQuery rmq = new RangeMinimumQuery(new int[]{5,8,6,3,1,7,2,6});
        //RangeMinimumQuery rmq = new RangeMinimumQuery(new int[]{5,8,6,3,1,7,2});
        System.out.println(Arrays.toString(rmq.segment) + " " + rmq.N + " " + rmq.segment.length);
        System.out.println(rmq.rangeMinQuery(1,2));
        System.out.println(rmq.rangeMinQueryIterative(1,3));
    }
}
