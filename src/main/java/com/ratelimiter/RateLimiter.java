package com.ratelimiter;

import java.util.LinkedList;
import java.util.Queue;

class RateLimiter {
    private int rateLimit;
    private int timeframe;
    private Queue<Long> requests;

    public RateLimiter(int rateLimit, int timeframe) {
        this.rateLimit = rateLimit;
        this.timeframe = timeframe;
        this.requests = new LinkedList<>();
    }

    public synchronized boolean isAllowed() {
        long currentTime = System.currentTimeMillis() / 1000;
        // Remove expired timestamps
        while (!requests.isEmpty() && requests.peek() <= currentTime - timeframe) {
            requests.poll();
        }
        // Check if rate limit is exceeded
        if (requests.size() >= rateLimit) {
            return false;
        }
        // Add current request timestamp
        requests.offer(currentTime);
        return true;
    }
}

/*
public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Create a rate limiter allowing 100 requests per minute
        RateLimiter limiter = new RateLimiter(100, 60);

        // Simulate 120 requests
        for (int i = 1; i <= 120; i++) {
            if (limiter.isAllowed()) {
                System.out.println("Request " + i + ": Allowed");
            } else {
                System.out.println("Request " + i + ": Rate limit exceeded");
            }
            Thread.sleep(500); // Sleep for half a second between requests
        }
    }
}

 */