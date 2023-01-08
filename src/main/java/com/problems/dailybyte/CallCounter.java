package com.problems.dailybyte;

import java.util.ArrayDeque;

public class CallCounter {

    ArrayDeque<Integer> counter;
    final int INTERVAL = 3000;
    //Create a class CallCounter that tracks the number of calls a client has made within the last 3 seconds. Your class should contain one method, ping(int t) that receives the current timestamp (in milliseconds) of a new call being made and returns the number of calls made within the last 3 seconds.
    //Note: you may assume that the time associated with each subsequent call to ping is strictly increasing.
    //
    //Ex: Given the following calls to ping…
    //
    //ping(1), return 1 (1 call within the last 3 seconds)
    //ping(300), return 2 (2 calls within the last 3 seconds)
    //ping(3000), return 3 (3 calls within the last 3 seconds)
    //ping(3002), return 3 (3 calls within the last 3 seconds)
    //ping(7000), return 1 (1 call within the last 3 seconds)

    public CallCounter(){
        counter = new ArrayDeque<>();
    }

    public int ping(int t){
        counter.offerLast(t);
        while(counter.size() > 0 && counter.peekFirst() < t - INTERVAL){
            counter.pollFirst();
        }
        return counter.size();
    }
}
