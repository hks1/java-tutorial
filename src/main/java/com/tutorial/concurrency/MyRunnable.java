package com.tutorial.concurrency;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        methodOne();
    }
    public void methodOne(){
        int localVariable1 = 45;

        MySharedObject localVariable2 = MySharedObject.sharedInstance;

        //... do more with local variables
        methodTwo();
    }
    public void methodTwo(){
        Integer localVariable1 = new Integer(99);

        //... do more with local variable.
    }
}
