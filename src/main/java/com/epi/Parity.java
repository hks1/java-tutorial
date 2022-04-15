package com.epi;

public class Parity {
    short[] preComputedParity;
    public short parityBruteForce(long n){
        short ans = 0;
        while(n != 0){
            ans ^= (n & 1);
            n >>>= 1;
        }
        return ans;
    }
    public short parity(long n){
        short ans = 0;
        while (n > 0){
            ans ^= 1;
            n = n & (n-1); // drops the lowest set bit of n
        }
        return ans;
    }
    public void populatePrecomputedParity(){
        preComputedParity = new short[(int) Math.pow(2, 16)];
        for(int i = 0; i < preComputedParity.length; i++){
            preComputedParity[i] = this.parity(i);
        }
        //System.out.println(preComputedParity.length);
        //System.out.println(preComputedParity[10] + " " + preComputedParity[7]);
    }
    public short computeParityWithCachedResults(long n){
        final int MASK_SIZE = 16;
        final int BIT_MASK = 0xFFFF;
        populatePrecomputedParity();
        return (short) ((short) preComputedParity[(int) ((n >>> (3 * MASK_SIZE)) & BIT_MASK)]
                        ^ preComputedParity[(int) ((n >>> (2 * MASK_SIZE)) & BIT_MASK) ]
                        ^ preComputedParity[(int) ((n >>> MASK_SIZE) & BIT_MASK)]
                        ^ preComputedParity[(int) (n & BIT_MASK)]);
    }
    public short parityLogNOrder(long x){
        x ^= (x >>> 32);
        x ^= (x >>> 16);
        x ^= (x >>> 8);
        x ^= (x >>> 4);
        x ^= (x >>> 2);
        x ^= (x >>> 1);
        return (short) (x & 0x1);
    }
}

class TDParity{
    public static void main(String[] args) {
        Parity obj = new Parity();
        obj.populatePrecomputedParity();
        obj.parityLogNOrder(Short.MAX_VALUE-2);
    }
}
