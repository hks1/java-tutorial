package com.ratelimiter;

import java.util.concurrent.TimeUnit;

public class TokenBucketRateLimiter {
    final int capacity;
    final double refillRatePerMilliSecond;
    double tokens;
    long lastRefillTimestamp;

    public TokenBucketRateLimiter(int capacity, double refillRate){
        this.capacity = capacity;
        this.tokens = capacity;
        this.refillRatePerMilliSecond = refillRate; // refillRate per millisecond -  default
        this.lastRefillTimestamp = System.currentTimeMillis();
    }
    // https://www.geeksforgeeks.org/timeunit-class-in-java-with-examples/

    public TokenBucketRateLimiter(int capacity, double refillRate, TimeUnit timeUnit){
        this(capacity, refillRate / timeUnit.toMillis(1));
    }

    public synchronized  boolean tryConsume(){
        refillTokens();
        if(tokens >= 1.0){
            tokens -= 1.0;
            return true;
        }
        return false;
    }

    public void refillTokens(){
        long currentTime = System.currentTimeMillis();
        long timeElapsed = currentTime - lastRefillTimestamp;
        double tokensToAdd = refillRatePerMilliSecond * timeElapsed;
        tokens = Math.min(capacity, tokens + tokensToAdd);
        lastRefillTimestamp = currentTime;
    }

    public static void main(String[] args) throws InterruptedException {
        TokenBucketRateLimiter limiter = new TokenBucketRateLimiter(50, 10, TimeUnit.SECONDS);

        int success = 0;
        int fail = 0;
        long start = System.currentTimeMillis();
        for(int i = 1; i <= 120; i++){
            if (limiter.tryConsume()){
                success++;
                System.out.println("request allowed..." + i);
            }else {
                fail++;
                System.out.println("request failed..." + i);
            }
            Thread.sleep(50);
        }
        long end = System.currentTimeMillis();
        long timeElapsed = end - start;
        System.out.println(timeElapsed + " ::success: " + success + ", failed: " + fail);
    }


}
