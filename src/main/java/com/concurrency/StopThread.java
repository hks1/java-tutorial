package com.concurrency;

import java.util.concurrent.TimeUnit;

public class StopThread {
    //private static boolean stopRequested = false;
    private static volatile boolean stopRequested = false;

    public static void main(String[] args) throws InterruptedException{
        Thread backgroundThread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (!stopRequested){
                    i++;
                }
            }
        });

        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;
    }
}
