package com.tutorial.concurrency;

public class CountDownLatch {
    private int count;
    public CountDownLatch(int count){
        if(count < 0){
            throw new IllegalArgumentException(count + " < 0");
        }
        this.count = count;
    }

    public void await(){
        while(true){
            synchronized (this){
                if(count == 0) { return;}
            }
        }
    }

    public synchronized void countDown(){
        if(count != 0){
            count--;
        }
    }
}
