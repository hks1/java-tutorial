package com.problems.educative;

import java.util.*;

public class Playground {
    public static void main(String[] args) throws InterruptedException {
        int[] arr = new int[10];
        int k = 3;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(arr[i]);
        }
        System.out.println(list);
        List<Integer> list1 = new ArrayList<>();
        list1.addAll(list);
        list.add(4);
        System.out.println(list);
        Collections.sort(list1, (a,b) -> b-a);
        System.out.println(list1);

        System.out.println(System.currentTimeMillis() + " " + new Date());

        /////////////////

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
