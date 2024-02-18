package com.tutorial.future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SquareCalculator {
    //private ExecutorService executorService = Executors.newSingleThreadExecutor();
    private ExecutorService executorService = Executors.newFixedThreadPool(2);

    public Future<Integer> calculate(Integer input){
        return executorService.submit(() -> {
            Thread.sleep(1000);
            return input * input;
        });
    }

    public void shutdown(){
        executorService.shutdown();
    }
}
