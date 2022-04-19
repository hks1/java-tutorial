package com.concurrency;

public class LazyInitialization {
    private static boolean initialized = false;

    static {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                initialized = true;
            }
        });
        t.start();
        try {
            t.join();
        } catch (InterruptedException e){
            throw new AssertionError(e);
        }
    }

    public static void main(String[] args) {
        System.out.println(initialized);
    }
}
