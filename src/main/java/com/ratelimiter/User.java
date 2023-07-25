package com.ratelimiter;

public class User {
    String username;
    RateLimiter limiter;
    public User(String username, int rateLimit, int timeFrame){
        this.username = username;
        limiter = new RateLimiter(rateLimit, timeFrame);
    }
}
