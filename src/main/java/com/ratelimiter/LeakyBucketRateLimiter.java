package com.ratelimiter;

public class LeakyBucketRateLimiter {

    public static void main(String[] args) {
        int windowSize = 200;
        long currentTime = System.currentTimeMillis()/1000;
        System.out.println(currentTime);
        System.out.println(currentTime - (currentTime % windowSize));
    }
}
