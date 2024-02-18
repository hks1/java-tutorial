package com.problems.codility;

/*
https://app.codility.com/programmers/lessons/1-iterations/binary_gap/
 */
public class BinaryGap {

    public int solution(int N){
        System.out.println("binary repr of no. " + N + ": " + Integer.toBinaryString(N));
        int binGap = 0;
        int gap = -1;
        while(N > 0){
            if(N % 2 == 0){
                gap = gap != -1 ? gap + 1 : gap;
                binGap = Math.max(binGap, gap);
            }else{
                gap = 0;
            }
            N = N >>> 1;
        }
        System.out.println("binary gap : " + binGap);
        return binGap;
    }
}
