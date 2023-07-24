package com.examples;

import java.util.*;

public class SnakeGame {

    int width;
    int height;
    int[][] food;
    Queue<Pair> snake;
    Set<Pair> set;

    Pair currentPosition;
    class Pair{
        int r;
        int c;

        public Pair(int r, int c){
            this.r = r;
            this.c = c;
        }

        @Override
        public String toString(){
            return "r: " + this.r + ", c: " + this.c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return r == pair.r && c == pair.c;
        }

        @Override
        public int hashCode(){
            return Objects.hash(r, c);
        }

    }

    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        snake  = new LinkedList<>();
        set = new HashSet<>();
        currentPosition = new Pair(0,0);
        /*snake.offer(new Pair(0,0));
        set.add(new Pair(0,0));*/
        snake.offer(currentPosition);
        set.add(currentPosition);

    }

    public int move(String direction) {

        return 0;
    }

    public static void main(String[] args) {
        SnakeGame obj = new SnakeGame(2, 3, new int[][]{{1,1}, {2,1}});
        System.out.println(obj.set.iterator().next().equals(obj.snake.peek()));
    }
}

/*
["SnakeGame","move","move"]
[[2,2,[[0,1]]],["R"],["D"]]

["SnakeGame","move","move","move","move","move"]
[[2,2,[[1,0]]],["R"],["D"],["L"],["U"],["R"]]

["SnakeGame","move","move","move","move","move","move","move","move","move","move","move","move"]
[[3,3,[[2,0],[0,0],[0,2],[2,2]]],["D"],["D"],["R"],["U"],["U"],["L"],["D"],["R"],["R"],["U"],["L"],["D"]]
 */
