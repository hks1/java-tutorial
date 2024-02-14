package com.ratelimiter;

import java.time.Instant;

public class ExecuteRequests implements Runnable{
    String user;

    IRateLimiter limiter;

    ExecuteRequests(String user, IRateLimiter limiter){
        this.user = user;
        this.limiter = limiter;
    }

    @Override
    public void run() {
        int success = 0;
        int fail = 0;
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            if(limiter.isAllowed()){
                success++;
                System.out.println("user: "  + this.user + " " + i + " request successful");
            }else{
                fail++;
                System.out.println("user: "  + this.user + " " + i + " request failed");
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        long end = System.currentTimeMillis();
        long timeElapsed = end - start;
        System.out.println("time elapsed: " + timeElapsed +
                ", success: " + success +
                ", failed: " + fail);
    }
}
