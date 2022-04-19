package com.tutorial.java.runnable.example;

public class Main {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new RunnableExample());
        thread1.start();

        // another way to create the thread
        // pass new instance of Runnable as an argument to the Thread constructor
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while(i <= 50){
                    System.out.println(i + " " + Thread.currentThread().getName() );
                    i++;
                }
            }
        });

        thread2.start();

        // another way to implement is using lambda
    }
}
