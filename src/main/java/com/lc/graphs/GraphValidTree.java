package com.lc.graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class GraphValidTree {
    //261. Graph Valid Tree
    //You have a graph of n nodes labeled from 0 to n - 1. You are given an integer n and a list of edges where edges[i] = [ai, bi] indicates that there is an undirected edge between nodes ai and bi in the graph.
    //
    //Return true if the edges of the given graph make up a valid tree, and false otherwise.
    public boolean validTree(int n, int[][] edges){
        // create adjList
        ArrayList<Integer>[] adjList = new ArrayList[n];
        for(int i = 0; i < n; i++){
            adjList[i] = new ArrayList<>();
        }
        // populate adjList
        for(int i = 0; i < edges.length; i++){
            int s = edges[i][0];
            int d = edges[i][1];
            adjList[s].add(d);
            adjList[d].add(s);
        }
        // initialize visited array
        int[] visited = new int[n];
        // initialize parent array
        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        int components = 0; // not tree if components > 1
        for(int i = 0; i < n; i++){
            if(visited[i] == 0){
                components++;
                if(components > 1){ // not connected
                    return false;
                }
                if(hasCycle(i, adjList, visited, parent)){ // cycle found
                    return false;
                }
            }
        }
        return true;
    }

    public boolean hasCycle(int node, ArrayList<Integer>[] adjList, int[] visited, int[] parent){
        visited[node] = 1;
        for (int ngb : adjList[node]){
            if(visited[ngb] == 0){
                parent[ngb] = node;
                if(hasCycle(ngb, adjList, visited, parent)){
                    return true;
                }
            }else{
                if(ngb != parent[node]){ //  back edge found, has cycle
                    return true;
                }
            }
        }
        return false;
    }
}
