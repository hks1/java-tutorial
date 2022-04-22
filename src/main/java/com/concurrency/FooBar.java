package com.concurrency;

public class FooBar {
    public static synchronized void main(String[] args){
        Thread t = new Thread(){
            @Override
            public void run() {
                bar();
            }
        };
        //t.run();
        t.start();
        System.out.println("foo ");
    }

    static synchronized void bar(){
        System.out.println("bar ");
    }
}
