package com.tutorial.thread_class;

public class Main {

    public static void main(String[] args) {
        System.out.println(Thread.activeCount());

        ThreadExample thread1 = new ThreadExample();
        thread1.setName("thread 001"); //optional, default name used if not set
        thread1.start();  // calls run() method
        System.out.println(thread1.isAlive()); // isAlive() returns true if code in run() method executing

        ThreadExample thread2 = new ThreadExample();
        //thread1.setName("First thread 001");
        thread2.start();  // calls run() method
    }
}
