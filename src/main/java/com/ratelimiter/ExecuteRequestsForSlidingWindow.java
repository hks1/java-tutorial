package com.ratelimiter;

public class ExecuteRequestsForSlidingWindow implements Runnable{
    String user;
    SlidingWindowRateLimiter limiter;

    public ExecuteRequestsForSlidingWindow(String user, SlidingWindowRateLimiter limiter){
        this.user = user;
        this.limiter = limiter;
    }
    @Override
    public void run() {
        int success = 0;
        int fail = 0;
        long start = System.currentTimeMillis();


        for (int i = 1; i <= 120; i++) {
            if (limiter.isAllowed()) {
                //System.out.println("User: " + user + ", Request " + i + ": Allowed");
                success++;
            } else {
                //System.out.println("User: " + user + ", Request " + i + ": Rate limit exceeded");
                fail++;
            }
            try {
                Thread.sleep(50); // Sleep for half a second between requests
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        long end = System.currentTimeMillis();
        long timeElapsed = end - start;
        System.out.println("time elapsed; " + timeElapsed + "User: " + user + ", success count: " + success + ", fail count: " + fail);
    }
}
