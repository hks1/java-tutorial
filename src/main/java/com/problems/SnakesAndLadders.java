package com.problems;

import java.util.*;

public class SnakesAndLadders {
    int[] visited;
    int[] distance;
    // 1. Build the graph
    // n = 101
    // given a hashmap with snakes and ladders
    // adjList = a 1D array of size 101
    // for each i in 0 to 100
        //adjList[i].append(hmap.get(i+1))
        //...
        //adjList[i].append(hmap.get(i+6))
    // minimum throws needed to reach 100
    // given hashmap with snakes and ladders
    public int minimumThrows(Map<Integer, Integer> snakesAndLadders){
        //let 0 be the source
        // number of nodes 0...101
        int n = 101;

        // build adjList
        List<Integer>[] adjList = new ArrayList[101];
        for(int i = 0; i < 101; i++){
            if(adjList[i] == null){
                adjList[i] = new ArrayList<>();
            }
            // add upto 6 edges
            for(int j = 1; j <= 6 && i+j < 101; j++){
                if(snakesAndLadders.containsKey(i+j)){
                    adjList[i].add(snakesAndLadders.get(i+j));
                }else{
                    adjList[i].add(i+j);
                }
            }
            /*for(int j = 0; j < adjList.length; j++){
                System.out.println(adjList[i]);
            }*/
        }
        //System.out.println(adjList[0]);
        //System.out.println(adjList[1]);
        // visited array
        visited = new int[n];
        // distance array
        distance = new int[n];
        bfs(0, adjList);
        return distance[100];

        //return 0;
    }

    public void bfs(int root, List<Integer>[] adjList){
        Queue<Integer> q = new LinkedList<>();
        q.add(root);
        visited[root] = 1;
        distance[root] = 0;
        while (q.size() > 0){
            System.out.println(q);
            System.out.println(Arrays.toString(distance));
            int node = q.poll();
            for (int ngb :
                    adjList[node]) {
                if(visited[ngb] == 0){
                    visited[ngb] = 1;
                    distance[ngb] = distance[node] + 1;
                    q.add(ngb);
                }
            }
        }
    }
}

class TDSnakesAndLadders{
    public static void main(String[] args) {
        Map<Integer, Integer> snakesAndLadders = new HashMap<>();

        snakesAndLadders.put(1,38);
        snakesAndLadders.put(4,14);
        snakesAndLadders.put(9, 31);
        snakesAndLadders.put(17,7);
        snakesAndLadders.put(21,42);
        snakesAndLadders.put(28,84);
        snakesAndLadders.put(51,67);
        snakesAndLadders.put(54,34);
        snakesAndLadders.put(62,19);
        snakesAndLadders.put(64,60);
        snakesAndLadders.put(72,91);
        snakesAndLadders.put(80,99);
        snakesAndLadders.put(87,36);
        snakesAndLadders.put(92,73);
        snakesAndLadders.put(95,75);
        snakesAndLadders.put(98,79);

        /*snakesAndLadders.put(94, 90);
        snakesAndLadders.put(96,92);
        snakesAndLadders.put(97, 91);
        snakesAndLadders.put(99, 89);*/

        SnakesAndLadders obj = new SnakesAndLadders();

        System.out.println(obj.minimumThrows(snakesAndLadders));
    }
}
