package com.lc.problems;

public class ContainerWithMostWater {
    public int maxArea(int[] height){
        int maxArea = 0;
        for(int i = 0; i < height.length; i++){
            int area = 0;
            for (int j = 1; j < height.length; j++){
                area = Math.min(height[i], height[j]) * (j-i);
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }
}
