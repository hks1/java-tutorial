package com.ratelimiter;

public class UserLimit {
    String username;
    SlidingWindowRateLimiter limiter;
    public UserLimit(String username, int rateLimit, int timeFrame){
        this.username = username;
        limiter = new SlidingWindowRateLimiter(rateLimit, timeFrame);
    }
}
