package com.epi;

public class CountBits {
    // count the number of bits that are set to 1 in a non-negative integer
    public short countBits(int n){
        short numBits = 0;
        while (n > 0){
            numBits += (n & 1);
            n >>= 1;
        }
        return numBits;
    }
}

class TDCountBits{
    public static void main(String[] args) {
        CountBits obj = new CountBits();
        System.out.println(obj.countBits(63));
    }
}
