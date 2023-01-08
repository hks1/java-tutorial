package com.lc.graphs;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CourseSchedule {
    //207. Course Schedule
    //There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
    //
    //For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
    //Return true if you can finish all courses. Otherwise, return false.
    int[] arr;
    int[] dep;
    int[] visited;
    static int timestamp = 0;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //adjList
        List<Integer>[] adjList = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++){
            adjList[i] = new ArrayList<>();
        }
        for(int i = 0; i < prerequisites.length; i++){
            adjList[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        // visited
        visited = new int[numCourses];
        // arr & dep
        arr = new int[numCourses];
        dep = new int[numCourses];
        Arrays.fill(arr, -1);
        Arrays.fill(dep, -1);
        for(int i = 0; i < numCourses; i++){
            if(visited[i] == 0){
                if(hasCycle(i, adjList)){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean hasCycle(int root, List<Integer>[] adjList){
        visited[root] = 1;
        arr[root] = timestamp++;
        for(int ngb : adjList[root]){
            if(visited[ngb] == 0){
                if(hasCycle(ngb, adjList)){ // cycle in subtree rooted at ngb
                    return true;
                }
            }else{
                if(dep[ngb] == -1){ // cycle (back edge) found
                    return true;
                }
            }
        }
        dep[root] = timestamp++;
        return false;
    }
}
