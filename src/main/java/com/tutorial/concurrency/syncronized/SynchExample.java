package com.tutorial.concurrency.syncronized;

public class SynchExample {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread threadA = new CounterThread(counter);
        Thread threadB = new CounterThread(counter);
        threadA.start();
        threadB.start();
    }
}

class Counter{
    long count = 0;
    public synchronized void add(long value){
        this.count += value;
    }
}

class CounterThread extends Thread{
    protected Counter counter = null;
    public CounterThread(Counter counter){
        this.counter = counter;
    }
    public void run(){
        for (int i = 0; i < 10; i++) {
            counter.add(i);
        }
    }
}

/*
If the two threads had referenced two separate Counter instances,
there would have been no problems calling the add() methods simultaneously.
The calls would have been to different objects,
so the methods called would also be synchronized on different objects (the object owning the method).
Therefore the calls would not block. Here is how that could look:
 */
/*
public class Example {

  public static void main(String[] args){
    Counter counterA = new Counter();
    Counter counterB = new Counter();
    Thread  threadA = new CounterThread(counterA);
    Thread  threadB = new CounterThread(counterB);

    threadA.start();
    threadB.start();
  }
}
 */