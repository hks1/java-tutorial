package com.ratelimiter;

import java.util.concurrent.TimeUnit;

public class TokenBucketRateLimiter {
    private final int capacity;
    private final double refillRate;
    private double tokens;
    private long lastRefillTimestamp;

    public TokenBucketRateLimiter(int capacity, double refillRate){
        this.capacity = capacity;
        this.refillRate = refillRate;
        tokens = this.capacity;
        lastRefillTimestamp = System.currentTimeMillis();
    }

    public TokenBucketRateLimiter(int capacity, double refillRate, TimeUnit timeUnit){
        this(capacity, refillRate / timeUnit.toMillis(1));
        // convert refill rate to tokens per millisecond for consistent calculation
        //this.refillRate = refillRate / timeUnit.toMillis(1);
        System.out.println("refillrate: " +this.refillRate);
    }

    public synchronized boolean tryConsume(int tokensRequired){
        refillTokens();
        if(tokensRequired <= tokens){
            tokens -= tokensRequired;
            return true;
        }
        return false;
    }

    public synchronized boolean tryConsume(){
        return this.tryConsume(1);
    }

    public void refillTokens(){
        long currentTime = System.currentTimeMillis();
        long timeElapsed = currentTime - lastRefillTimestamp;
        double tokensToAdd = (timeElapsed / 1000.0) * refillRate;
        tokens = Math.min(capacity, tokens + tokensToAdd);
        System.out.println(timeElapsed + " tokenToAdd: " + tokensToAdd + " tokens: " + tokens );
        lastRefillTimestamp = currentTime;
    }

    public static void main(String[] args) throws InterruptedException{
        //TokenBucketRateLimiter limiter = new TokenBucketRateLimiter(100, 10);
        TokenBucketRateLimiter limiter = new TokenBucketRateLimiter(100, 10, TimeUnit.SECONDS );
        long start = System.currentTimeMillis();
        int success = 0, fail = 0;

        for (int i = 0; i < 120; i++) {
            if(limiter.tryConsume()){
                System.out.println("Request processed ->" + i);
                success++;
            }else {
                System.out.println("rate limit exceeded ->" + i);
                fail++;
            }

            Thread.sleep(500);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start + " success: " + success + " fail: " + fail);
    }
}
