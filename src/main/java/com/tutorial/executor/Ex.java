package com.tutorial.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ex {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0 ;i < 5; i++){
            int j = i;
            executorService.submit(() -> System.out.println(print(j)));
        }
        executorService.shutdown();
    }

    public static String print(int i){
        return String.valueOf(i);
    }
}
