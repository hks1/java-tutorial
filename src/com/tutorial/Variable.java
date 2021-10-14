package com.tutorial;

import javax.swing.plaf.IconUIResource;
import java.util.Arrays;

public class Variable {
    public static void main(String[] args) {
        Byte myByte = 127;
        System.out.println(myByte.intValue());
        System.out.println(5%2);
        int result = 100 * 100 / (5 + 200) * 3 / 2;
        System.out.println(result);
        System.out.println(12.0/5);
        System.out.println(12/5);
        System.out.println(12D/5D);
        double num = 12.0;
        double den = 5;
        double var = num/den;
        System.out.println(var);
        double resultDbl3 = 0D;
        System.out.println(resultDbl3);
        for (int i = 0; i < 100; i++) {
            resultDbl3 += 0.1D;
        }
        System.out.println(resultDbl3);
        System.out.println(Math.abs(-76));
        System.out.println(-5/2);
        System.out.println(Math.floorDiv(-5,2));
        double random = Math.random();
        System.out.println(random + " : " + Math.round(random*100));
        System.out.println(Math.exp(1));
        System.out.println(Math.pow(4,.5));
        System.out.println(Math.toRadians(180));
        System.out.println(Math.toDegrees(Math.PI));
        int[] ints;
        int y = 10;
        ints = new int[y];
        int[] ints1 = {1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,0,};
        System.out.println(Arrays.toString(ints1));

        //Arrays class
        int[] source = new int[10];
        for (int i = 0; i < source.length; i++) {
            source[i] = i;
        }
        int[] dest = Arrays.copyOf(source, source.length);
        int[] dest1 = Arrays.copyOfRange(source, 0, source.length);
        System.out.println(Arrays.toString(ints1));
        Arrays.sort(ints1);
        System.out.println(Arrays.toString(ints1));


    }
}
