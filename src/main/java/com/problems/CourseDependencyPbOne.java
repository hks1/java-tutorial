package com.problems;

import java.util.*;

public class CourseDependencyPbOne {

    Map<Character, Integer> indegree;// = new HashMap<>();
    Map<Character, Integer> outdegree;// = new HashMap<>();

    public Map<Character, ArrayList<Character>> findDependency(char[][] dependencies){
        Map<Character, ArrayList<Character>> result = new HashMap<>();
        Map<Character, ArrayList<Character>> adjMap = new HashMap<>(); // S(n) : num courses + num edges (dependencies.length)
        //Map<Character, Integer>
                indegree = new HashMap<>(); // S(n): num courses
        //Map<Character, Integer>
                outdegree = new HashMap<>(); // S(n): num courses
        for(char[] dependency : dependencies){ // T(n): num edges
            char course1 = dependency[0];
            char course2 = dependency[1];
            if(adjMap.containsKey(course1)){
                adjMap.get(course1).add(course2);
            }else{
                ArrayList<Character> tempList = new ArrayList<>();
                tempList.add(course2);
                adjMap.put(course1, tempList);
            }
            outdegree.put(course1, outdegree.getOrDefault(course1, 0) + 1);
            indegree.put(course2, indegree.getOrDefault(course2, 0) + 1);
        }
        System.out.println(adjMap + "\n " +outdegree  + "\n " + indegree);
        Set<Character> visited = new HashSet<>();
        for(Character node : adjMap.keySet()){ // T(n): num courses - visiting every node once only so T(n) = O(n)
            if(indegree.containsKey(node)){
                continue;
            }
            if(!visited.contains(node)){
                if(!indegree.containsKey(node)){
                    result.put(node, new ArrayList<>());
                }
                dfs(node, visited, adjMap, result.get(node));
            }
        }
        System.out.println(result);
        return result;
    }

    public void dfs(char node, Set<Character> visited, Map <Character, ArrayList<Character>> adjMap, ArrayList<Character> result){
        visited.add(node);
        for(char ngb : adjMap.get(node)){
            if(!visited.contains(ngb)){
                if(!outdegree.containsKey(ngb)){
                    visited.add(ngb);
                    result.add(ngb);
                }else{
                    dfs(ngb, visited, adjMap, result);
                }
            }
        }
    }
}

class TDCourseDependencyPbOne{
    public static void main(String[] args) {
        char[][] courses = {{'A','B'},{'A','C'},{'B','K'},{'C','K'},{'L','M'},{'L','N'},{'D','E'},{'D','J'},{'E','F'},{'E','G'},{'F','H'},{'G','I'}};
        CourseDependencyPbOne obj = new CourseDependencyPbOne();
        obj.findDependency(courses);
    }
}
