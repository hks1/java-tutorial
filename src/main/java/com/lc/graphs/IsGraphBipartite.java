package com.lc.graphs;

import org.w3c.dom.xpath.XPathResult;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class IsGraphBipartite {
    //785. Is Graph Bipartite?
    //Medium
    //
    //4741
    //
    //277
    //
    //Add to List
    //
    //Share
    //There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1. You are given a 2D array graph, where graph[u] is an array of nodes that node u is adjacent to. More formally, for each v in graph[u], there is an undirected edge between node u and node v. The graph has the following properties:
    //
    //There are no self-edges (graph[u] does not contain u).
    //There are no parallel edges (graph[u] does not contain duplicate values).
    //If v is in graph[u], then u is in graph[v] (the graph is undirected).
    //The graph may not be connected, meaning there may be two nodes u and v such that there is no path between them.
    //A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that every edge in the graph connects a node in set A and a node in set B.
    //
    //Return true if and only if it is bipartite.
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] visited = new int[n];
        int[] distance = new int[n];
        Arrays.fill(distance, -1);
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        for(int i = 0; i < n; i++){
            if(visited[i] == 0){
                if(hasOddCycle(i, graph, visited, distance, parent)){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean hasOddCycle(int node, int[][] graph, int[] visited, int[] distance, int[] parent){
        visited[node] = 1;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(node);
        distance[node] = 0;
        while(queue.size() > 0){
            int v = queue.poll();
            for(int ngb: graph[v]){
                if(visited[ngb] == 0){
                    visited[ngb] = 1;
                    //parent[ngb] = v;
                    distance[ngb] = distance[v] + 1;
                    queue.add(ngb);
                }else{
                    if(distance[ngb] == distance[v]){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // dfs - check odd length cycle
    public boolean dfs(){
        return true;
    }
}
