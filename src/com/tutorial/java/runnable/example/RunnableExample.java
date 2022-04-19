package com.tutorial.java.runnable.example;

public class RunnableExample implements Runnable{
    // In java you only allow to extend one class
    // so advang
    @Override
    public void run() {
        int i = 0;
        while(i <= 100){
            System.out.println(i + " " + Thread.currentThread().getName());
            i++;
        }
    }
}
