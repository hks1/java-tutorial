package com.tutorial.executor;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

// https://howtodoinjava.com/java/multi-threading/executorservice-shutdown/
public class ShutdownExecutor {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService executor =
                Executors.newScheduledThreadPool(3);
        System.out.println("Worker tasks scheduled at: " + LocalDateTime.now());

        ScheduledFuture<String> result1 = executor.schedule(
                new WorkerTask("WorkerTask-1"), 10, TimeUnit.SECONDS
        );

        ScheduledFuture<String> result2 = executor.schedule(
                new WorkerTask("WorkerTask-2"), 20, TimeUnit.SECONDS
        );

        ScheduledFuture<String> result3 = executor.schedule(
                new WorkerTask("WorkerTask-3"), 30, TimeUnit.SECONDS
        );

        Thread.sleep(15_000);

        System.out.println("***********Shutting down the executor service*********");
        executor.shutdown();

        System.out.println("***********Tasks are partially completed*********");

        System.out.println("Task-1 is done : " + result1.isDone());
        System.out.println("Task-2 is done : " + result2.isDone());
        System.out.println("Task-3 is done : " + result3.isDone());

        System.out.println("***********Waiting for tasks to be complete*********");
        executor.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println("***********All tasks are completed now*********");

        System.out.println("Task-1 is done : " + result1.isDone());
        System.out.println("Task-2 is done : " + result2.isDone());
        System.out.println("Task-3 is done : " + result3.isDone());

    }
}
