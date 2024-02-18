package com.ratelimiter;

import java.time.Instant;
import java.util.ArrayDeque;
import java.util.Queue;

public class FixedWindowRateLimiter implements IRateLimiter{
    private final int limit; // max number of reqs allowed within the time window
    private final int windowSeconds;
    Queue<Instant> requestQueue;

    public FixedWindowRateLimiter(int limit, int windowSeconds){
        this.limit = limit;
        this.windowSeconds = windowSeconds;
        this.requestQueue = new ArrayDeque<>();
    }

    public synchronized boolean isAllowed(){
        clearExpiredRequests();
        if(requestQueue.size() < limit){
            requestQueue.offer(Instant.now());
            return true;
        }else{
            return false;
        }
    }

    private void clearExpiredRequests(){
        Instant now = Instant.now();
        Instant windowStart = now.minusSeconds(windowSeconds);

        while(!requestQueue.isEmpty() && requestQueue.peek().isBefore(windowStart)){
            requestQueue.poll(); // remove expired requests from the queue
        }
    }


    public static void main(String[] args) {
        //FixedWindowRateLimiter limiter = new FixedWindowRateLimiter(2, 1);

        /*for (int i = 0; i < 10; i++) {
            if(limiter.isAllowed()){
                System.out.println(i + " request allowed.");
            }else{
                System.out.println(i + " not allowed");
            }
        }*/

        /*IRateLimiter limiter = new FixedWindowRateLimiter(2, 1);
        Thread thread = new Thread(new ExecuteRequests("user1", limiter));
        thread.start();*/

        for (int i = 0; i < 5; i++) {
            String user = String.valueOf(i);
            IRateLimiter limiter = new FixedWindowRateLimiter(2,1);
            Thread thread1 = new Thread(new ExecuteRequests(user, limiter));
            thread1.start();
        }

        System.out.println(Instant.now());

    }
}
