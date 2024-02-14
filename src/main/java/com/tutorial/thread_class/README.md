// thread

https://stackoverflow.com/questions/877096/how-can-i-pass-a-parameter-to-a-java-thread

> public final void join() throws InterruptedException
Waits for this thread to die.

// https://www.baeldung.com/java-thread-join

**When we invoke the join() method on a thread, the calling thread goes into a waiting state. It remains in a waiting state until the referenced thread terminates.**

**The join() method may also return if the referenced thread is interrupted.**  In this case, the method throws an _InterruptedException_.

Thread.join() Methods with Timeout

There are two [timed versions](https://docs.oracle.com/en/java/javase/19/docs/api/java.base/java/lang/Thread.html#join(long)) that overload the join() method:

>“public final void join(long millis) throws InterruptedException
Waits at most millis milliseconds for this thread to die. A timeout of 0 means to wait forever.”

>“public final void join(long millis,intnanos) throws InterruptedException
Waits at most millis milliseconds plus nanos nanoseconds for this thread to die.”

**Timed _join()_ is dependent on the OS for timing. So, we cannot assume that join() will wait exactly as long as specified.**

**TBD** Thread.join() Methods and Synchronization
-  join() creates a happens-before relationship:
>“All actions in a thread happen-before any other thread successfully returns from a join() on that thread.”

[Chapter 17. Threads and Locks](https://docs.oracle.com/javase/specs/jls/se8/html/jls-17.html#jls-17.4.5)

**Example**

```java
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
```

isAlive()


<!-- https://www.baeldung.com/java-thread-join -->
<!-- https://github.com/eugenp/tutorials/tree/master/core-java-modules/core-java-concurrency-simple -->
<!-- https://docs.oracle.com/en/java/javase/19/docs/api/java.base/java/lang/Thread.html#join(long) -->
<!-- https://docs.oracle.com/javase/specs/jls/se8/html/jls-17.html#jls-17.4.5 -->