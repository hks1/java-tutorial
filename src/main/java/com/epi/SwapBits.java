package com.epi;

public class SwapBits {
    public static long swapBits(long x, int i, int j){
        if(((x >>> i) & 1) != ((x >>> j) & 1)){
            //long bitmask = ((1 << i) | (i << j));
            x ^= ((1 << i) | (1 << j));
        }
        return x;
    }
}
