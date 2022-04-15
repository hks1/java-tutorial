package com.epi;

public class PrimitiveTypes {
    public int rightPropagateRightMostSetBit(int x){
        return x | (x - 1);
    }
    public boolean isPowerOfTwo(long x){
        return (x & (x-1)) == 0;
    }
}

class TDPrimitiveTypes{
    public static void main(String[] args) {
        int x = 0;
        System.out.println( x-1 + " : " + Integer.toBinaryString(x-1));
    }
}
