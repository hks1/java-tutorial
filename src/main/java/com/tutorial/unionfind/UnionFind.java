package com.tutorial.unionfind;

public class UnionFind {

    // merge subtrees rooted at u and v if there is an edge between u and v
    public int union(int n, int[][] edges){
        int[] size = new int[n];
        int[] parent = new int[n];
        // initialize no. of components to n
        int components = n;
        // initialize parent with node itself
        // initialize size of each subtree to 1
        for (int i = 0; i < n; i++){
            parent[i] = i;
            size[i] = 1;
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int rootu = find(u, parent);
            int rootv = find(v, parent);

            if(rootu != rootv){
                if(size[rootu] < size[rootv]){
                    parent[rootu] = rootv;
                    size[rootv] += size[rootu];
                } else {
                    parent[rootv] = rootu;
                    size[rootu] += size[rootv];
                }
                components--;
            }
        }
        return components;
    }

    // find root of tree containing node
    /*public int find(int node, int[] parent){
        while(node != parent[node]){
            node = parent[node];
        }
        return node;
    }*/

    // find implementation with path compression
    public int find(int x, int[] parent){
        // base case
        if(x == parent[x]) return x;
        // base case
        int rootx = find(parent[x], parent);
        parent[x] = rootx;
        return rootx;
    }
}

class Test{
    public static void main(String[] args) {
        UnionFind obj = new UnionFind();
        //int components = obj.union(4, new int[][]{{0,1}, {1,2}, {1,3}});
        int components = obj.union(7, new int[][]{{0,1}, {1,2}, {1,3}, {6,5}});
        System.out.println(components);
    }
}
