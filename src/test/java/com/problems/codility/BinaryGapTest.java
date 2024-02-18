package com.problems.codility;

import com.problems.codility.BinaryGap;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinaryGapTest {

    BinaryGap obj;

    @BeforeEach
    void setUp() {
        obj = new BinaryGap();
    }

    @Test
    void solution() {
        Assert.assertEquals(0, obj.solution(1));
        Assert.assertEquals(0, obj.solution(0));
        Assert.assertEquals(2, obj.solution(9));
        Assert.assertEquals(4, obj.solution(529));
        Assert.assertEquals(1, obj.solution(20));
        Assert.assertEquals(0, obj.solution(15));
        int N = 32;
        Assert.assertEquals(0, obj.solution(N));
        Assert.assertEquals(5, obj.solution(1041));
        /*System.out.println(Integer.toBinaryString(N));
        int gap = 0;
        int maxGap = 0;
        while(N > 0){
            if(N%2 == 0) gap++;
            else gap = 0;
            maxGap = Math.max(maxGap, gap);
            System.out.println(N >>> 1);
            N = N >>> 1;
        }
        System.out.println("result: " + maxGap);*/
    }

    @Test
    void test(){
        int bitmask = 0x000F;
        int val = 0x2222;
        System.out.println("bitmask: " + bitmask + ", bitmask in bin: " + Integer.toBinaryString(bitmask) + "," +
                "\nval: " + val + ", val in bin: " + Integer.toBinaryString(val));
        System.out.println(val & bitmask);
        System.out.print(val | bitmask);
        System.out.println(Integer.toBinaryString(val | bitmask));
        System.out.print(val ^ bitmask);
        System.out.println(Integer.toBinaryString(val ^ bitmask));

    }
}