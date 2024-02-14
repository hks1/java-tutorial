package com.ratelimiter;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<String, SlidingWindowRateLimiter> rateLimiterMap;
    public static void main(String[] args) throws InterruptedException {
        rateLimiterMap = new HashMap<>();
        String[][] userDetails = new String[][] {{"user1", "10", "1"},
                {"user2", "9", "10"},
                {"user3", "8", "20"}};


        for (String[] userDetail :
                userDetails) {
            String user = userDetail[0];
            Integer rateLimit = Integer.valueOf(userDetail[1]);
            Integer timeFrame = Integer.valueOf(userDetail[2]);

            if(!rateLimiterMap.containsKey(user)){
                rateLimiterMap.put(user, new SlidingWindowRateLimiter(rateLimit, timeFrame));
            }

            Thread thread = new Thread(new ExecuteRequestsForSlidingWindow(user, rateLimiterMap.get(user)));
            thread.start();
            /*int success = 0;
            int fail = 0;

            for (int i = 1; i <= 120; i++) {
                if (rateLimiterMap.get(user).isAllowed()) {
                    //System.out.println("User: " + user + ", Request " + i + ": Allowed");
                    success++;
                } else {
                    //System.out.println("User: " + user + ", Request " + i + ": Rate limit exceeded");
                    fail++;
                }
                Thread.sleep(50); // Sleep for half a second between requests
            }
            long end = System.currentTimeMillis();
            long timeElapsed = end - start;
            System.out.println("time elapsed; " + timeElapsed + "User: " + user + ", success count: " + success + ", fail count: " + fail);*/
        }

    }

    //public void executeRequests(String user, int rateLimit, int timeFrame) throws InterruptedException {
    public void executeRequests(String user, SlidingWindowRateLimiter limiter) throws InterruptedException {
        int success = 0;
        int fail = 0;
        long start = System.currentTimeMillis();


        for (int i = 1; i <= 120; i++) {
            if (rateLimiterMap.get(user).isAllowed()) {
                //System.out.println("User: " + user + ", Request " + i + ": Allowed");
                success++;
            } else {
                //System.out.println("User: " + user + ", Request " + i + ": Rate limit exceeded");
                fail++;
            }
            Thread.sleep(50); // Sleep for half a second between requests
        }
        long end = System.currentTimeMillis();
        long timeElapsed = end - start;
        System.out.println("time elapsed; " + timeElapsed + "User: " + user + ", success count: " + success + ", fail count: " + fail);
    }
}
