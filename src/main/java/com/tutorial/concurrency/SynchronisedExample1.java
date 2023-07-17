package com.tutorial.concurrency;

// https://stackoverflow.com/questions/2423622/volatile-vs-static-in-java
// volatile is not always enough

public class SynchronisedExample1 {

    public static final Object counterLock = new Object();
    private static volatile int counter = 0;

    private void concurrentMethodWrong(int i) throws InterruptedException {
        //System.out.println(System.currentTimeMillis());
        counter += 5;
        Thread.sleep(i * 100);
        counter -= 5;
        //System.out.println(System.currentTimeMillis());
    }

    private void concurrentMethodRight(int i) throws InterruptedException {
        synchronized (counterLock){
            counter += 5;
        }
        Thread.sleep(i * 100);
        synchronized (counterLock){
            counter -= 5;
        }
    }

    private void testConcurrentMethodWrong(){

        long start = System.nanoTime();

        System.out.println("starting testConcurrentMethodWrong(): " + start);


        for (int i = 0; i < 100; i++) {
            //System.out.println(System.currentTimeMillis());
            int finalI = i;
            Thread thread = new Thread(() -> {
                //System.out.println(System.currentTimeMillis());
                try {
                    concurrentMethodWrong(finalI);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                //System.out.println(System.currentTimeMillis());
            });
            thread.start();
        }
        long end = System.nanoTime();
        System.out.println("end      testConcurrentMethodWrong(): " + end);
        System.out.println("testConcurrentMethodWrong() >> total time taken: " + (end - start) + ", counter value: " +counter);
    }

    private void testConcurrentMethodRight(){
        System.out.println("testConcurrentMethodRight() >> value of counter: " + counter);
        long start = System.nanoTime();
        System.out.println("starting testConcurrentMethodRight(): " + start);
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            Thread thread = new Thread(() -> {
                try {
                    concurrentMethodRight(finalI);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        long end = System.nanoTime();
        System.out.println("end      testConcurrentMethodRight(): " + end);
        System.out.println("testConcurrentMethodRight() >> total time taken: " + (end - start) + ", counter value: " +counter);
        //System.out.println("value of counter variable after calling concurrentMethodRight(): " + counter);

    }



    public static void main(String[] args) {
        SynchronisedExample1 obj = new SynchronisedExample1();
        obj.testConcurrentMethodWrong();
        //System.out.println("value of 'counter' variable before calling concurrentMethodRight(): " + counter);
        obj.testConcurrentMethodRight();

    }
}
