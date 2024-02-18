package com.ratelimiter;

import java.security.PublicKey;
import java.time.Instant;
import java.util.LinkedList;
import java.util.Queue;

public class LeakyBucketRateLimiter implements IRateLimiter{
    protected final int maxRequestsPerSec;
    private long nextAllowedTime;
    private final long REQUEST_INTERVAL_MILLIS;

    public LeakyBucketRateLimiter(int maxRequestsPerSec){
        this.maxRequestsPerSec = maxRequestsPerSec;
        REQUEST_INTERVAL_MILLIS = 1000  / maxRequestsPerSec;
        nextAllowedTime = System.currentTimeMillis();
    }

    @Override
    public boolean isAllowed() {
        long curTime = System.currentTimeMillis();
        synchronized (this){
            if (curTime >= nextAllowedTime){
                nextAllowedTime = curTime + REQUEST_INTERVAL_MILLIS;
                return true;
            }
        }
        return false;
    }



    public static void main(String[] args) {
        long curTime = System.currentTimeMillis();
        System.out.println(curTime + " " + Instant.now());


        for (int i = 0; i < 5; i++) {
            String user = String.valueOf(i);
            IRateLimiter limiter = new LeakyBucketRateLimiter(2);
            Thread thread1 = new Thread(new ExecuteRequests(user, limiter));
            thread1.start();
        }
    }
}
