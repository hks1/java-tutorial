package com.tutorial.concurrency.syncronized;

// Example: scenario when declaring a variable as volatile is not thread-safe

public class SynchronizedExample2 {

    static volatile int count = 0;
    public static void increment(){
        count++;
    }



    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int index = 0; index < 1000; index++){
                    increment();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int index = 0; index < 1000; index++){
                    increment();
                }
            }
        });

        thread1.start();
        thread2.start();

        //Thread.sleep(1000);  // make it sleep if there are no below join statements added

        thread1.join(); // wait for thread1 to die
        thread2.join(); // wait for thread2 to die

        System.out.println("value of count variable is " + count);
    }
}
