package com.lc.problems;

import java.util.Arrays;
import java.util.Comparator;

public class KClosestPointsToOrigin {
    //973. K Closest Points to Origin
    //Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).
    //
    //The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
    //
    //You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
    public int[][] kClosest(int[][] points, int k){
        Comparator<int[]> distanceComparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]*o1[0] + o1[1]*o1[1];
            }
        };

        Arrays.sort(points, distanceComparator);

        return Arrays.copyOf(points, k);
    }
}
