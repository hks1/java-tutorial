package com.problems.dailybyte;

import java.util.Arrays;

public class MovingBricks {

    public int maxNumBricks(int[] bricks, int maxWeight){
        Arrays.sort(bricks);
        int num = 0;
        int total = 0;
        for(int brick : bricks){
            if (total + brick < maxWeight) {
                total += brick;
                num++;
            }
        }
        return num;
    }
}
