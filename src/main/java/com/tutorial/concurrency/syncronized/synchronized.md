
concurrency utility classes -> helps developers implement more fine grained concurrency control than what you get with `synchronized`.

# synchronized
A synchronized block in Java is synchronized on some object.
All synchronized blocks synchronized on the same object can only have one thread executing inside them at the same time.
All other threads attempting to enter the synchronized block are blocked until the thread inside the synchronized block exits the block.

The `synchronized` keyword can be used to mark four different types of blocks:

1. Instance methods
2. Static methods
3. Code blocks inside instance methods
4. Code blocks inside static methods

These blocks are synchronized on different objects. Which type of synchronized block you need depends on the concrete situation.

## Synchronized Instance Methods
```java
public class myCounter{
    private int count = 0;
    public synchronized void add(int value){
        this.count += value;
    }
}
```
A synchronized instance method in Java is synchronized on the instance (object) owning the method.

only one thread can execute inside either of of the two synchronized methods. One thread in total per instance:
```java
public class MyCounter {

  private int count = 0;

  public synchronized void add(int value){
      this.count += value;
  }
  public synchronized void subtract(int value){
      this.count -= value;
  }

}
```
## Synchronized Static Methods
```java
public static class MyStaticCounter{

  private static int count = 0;

  public static synchronized void add(int value){
      count += value;
  }
}
```
Synchronized static methods are synchronized on the class object of the class the synchronized static method belongs to.

In case a class contains more than one static synchronized method, only one thread can execute inside any of these methods at the same time.

Example:
```java
public static class MyStaticCounter{

  private static int count = 0;

  public static synchronized void add(int value){
    count += value;
  }

  public static synchronized void subtract(int value){
    count -= value;
  }
}
```

> Only one thread can execute inside any of the two add() and subtract() methods at any given time. If Thread A is executing add() then Thread B cannot execute neither add() nor subtract() until Thread A has exited add().

## Synchronized Blocks in Instance Methods
```java
public void add(int value){

    synchronized(this){
       this.count += value;   
    }
  }
```

- The object taken in the parentheses by the synchronized construct is called a monitor object.
- The code is said to be synchronized on the monitor object.
- A synchronized instance method uses the object it belongs to as monitor object.

```java
public class MyClass {
  
    public synchronized void log1(String msg1, String msg2){
       log.writeln(msg1);
       log.writeln(msg2);
    }

  
    public void log2(String msg1, String msg2){
       synchronized(this){
          log.writeln(msg1);
          log.writeln(msg2);
       }
    }
  }
```

Only a single thread can execute inside either of the two synchronized blocks in this example.

Had the second synchronized block been synchronized on a different object than this, then one thread at a time had been able to execute inside each method.


## Synchronized Blocks in Static Methods
```java
public class MyClass {

    public static synchronized void log1(String msg1, String msg2){
       log.writeln(msg1);
       log.writeln(msg2);
    }

  
    public static void log2(String msg1, String msg2){
       synchronized(MyClass.class){
          log.writeln(msg1);
          log.writeln(msg2);  
       }
    }
  }
```

One thread can execute inside any of these two methods at the same time.

Had the second synchronized block been synchronized on a different object than MyClass.class, then one thread could execute inside each method at the same time.

## Synchronized Blocks in Lambda Expressions
It is even possible to use synchronized blocks inside a Java Lambda Expression as well as inside anonymous classes.

```java
import java.util.function.Consumer;

public class SynchronizedExample {

  public static void main(String[] args) {

    Consumer<String> func = (String param) -> {

      synchronized(SynchronizedExample.class) {

        System.out.println(
            Thread.currentThread().getName() +
                    " step 1: " + param);

        try {
          Thread.sleep( (long) (Math.random() * 1000));
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

        System.out.println(
            Thread.currentThread().getName() +
                    " step 2: " + param);
      }

    };


    Thread thread1 = new Thread(() -> {
        func.accept("Parameter");
    }, "Thread 1");

    Thread thread2 = new Thread(() -> {
        func.accept("Parameter");
    }, "Thread 2");

    thread1.start();
    thread2.start();
  }
}
```

## Example
<!-- SynchExample.java -->
```java
package com.tutorial.memorymodel;

public class SynchExample {
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
```

If the two threads had referenced two separate Counter instances,
there would have been no problems calling the add() methods simultaneously.
The calls would have been to different objects,
so the methods called would also be synchronized on different objects (the object owning the method).
Therefore the calls would not block. Here is how that could look:
```java
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
```

## Synchronized and Data Visibility
Without the use of the `synchronized` keyword (or the **Java volatile** keyword) 
there is no guarantee that when one thread changes the value of a variable shared with other threads (e.g. via an object all threads have access to), 
that the other threads can see the changed value. 
There are no guarantees about when a variable kept in a CPU register by one thread is "committed" to main memory, 
and there is no guarantee about when other threads "refresh" a variable kept in a CPU register from main memory.

The `synchronized` keyword changes that. 
When a thread enters a synchronized block it will refresh the values of all variables visible to the thread. 
When a thread exits a synchronized block all changes to variables visible to the thread will be committed to main memory. 
This is similar to how the **volatile** keyword works.

## Synchronized and Instruction Reordering
The Java compiler and Java Virtual Machine are allowed to reorder instructions in your code to make them execute faster, typically by enabling the reordered instructions to be executed in parallel by the CPU.

Instruction reordering could potentially cause problems in code that is executed by multiple threads at the same time. For instance, if a write to a variable happening inside of a synchronized block was reordered to happen outside of the synchronized block.

To fix this problem the Java synchronized keyword places some restrictions on reordering of instructions before, inside and after synchronized blocks. This is similar to the restrictions placed by the **volatile keyword**.

The end result is, that you can be sure that your code works correctly - that no instruction reordering is taking place that ends up making the code behave differently than what was to be expected from the code you wrote.

## What Objects to Synchronize On
It is recommended that you do not synchronize on String objects, 
or any primitive type wrapper objects, 
as the compiler might optimize those, 
so that you are using the same instances in different places in your code where you thought you were using different instance.

Example:
```java
synchronized("Hey"){
    //...
        }
```
If there are more than one synchronized block that is synchronized on the literal String value "Hey", 
then the compiler might actually use the same String object behind the scenes. 
The result being, that both of these two synchronized blocks are then synchronized on the same object. 
That might not be the behaviour you were looking for.

The same can be true for using primitive type wrapper objects. 

example:
```java
synchronized(Integer.valueOf(1)) {
//do something in here.
}
```
If you call Integer.valueOf(1) multiple times, it might actually return the same wrapper object instance for the same input parameter values. That means, that if you are synchronizing multiple blocks on the same primitive wrapper object (e.g. use Integer.valueOf(1) multiple times as monitor object), then you risk that those synchronized blocks all get synchronized on the same object. 
That might also not be the behaviour you were looking for.

> To be on the safe side, synchronize on this - or on a new Object() . Those are not cached or reused internally by the Java compiler, Java VM or Java libraries.

## Synchronized Block Limitations and Alternatives
- what if two threads just wanted to read a shared value, and not update it?
> As alternative to a synchronized block you could guard the code with a Read / Write Lock which as more advanced locking semantics than a synchronized block. Java actually comes with a built in ReadWriteLock class you can use.

- What if you want to allow N threads to enter a synchronized block, and not just one?
> You could use a Semaphore to achieve that behaviour. Java actually comes with a built-in Java Semaphore class you can use.

- What if you need to guarantee that threads trying to enter a synchronized block get access in the exact sequence they requested access to it?
> You need to implement [Fairness](https://jenkov.com/tutorials/java-concurrency/starvation-and-fairness.html) yourself.

- What if you just have one thread writing to a shared variable, and other threads only reading that variable?
> use a volatile variable without any synchronization around.

## Synchronized Block Performance Overhead
- performance overhead associated with entering and exiting a synchronized block
- try not to have larger synchronized blocks than necessary.

## Synchronized Block Reentrance
- Once a thread has entered a synchronized block the thread is said to "hold the lock" on the monitoring object the synchronized block is synchronized on.
- If the thread calls another method which calls back to the first method with the synchronized block inside, the thread holding the lock can reenter the synchronized block.
- It is not blocked just because a thread (itself) is holding the lock. Only if a differen thread is holding the lock.

Example:
```java
public class MyClass {
    
  List<String> elements = new ArrayList<String>();
    
  public void count() {
    if(elements.size() == 0) {
        return 0;
    }
    synchronized(this) {
       elements.remove();
       return 1 + count();  
    }
  }
    
}
```

> Keep in mind though, that designs where a thread enters into multiple synchronized blocks may lead to [nested monitor lockout](https://jenkov.com/tutorials/java-concurrency/nested-monitor-lockout.html) if you do not design your code carefully.

## Synchronized Blocks in Cluster Setups
Keep in mind that a synchronized block only blocks threads within the same Java VM from entering that code block. If you have the same Java application running on multiple Java VMs - in a cluster - then it is possible for one thread within each Java VM to enter that synchronized block at the same time.

If you need synchronization across all Java VMs in a cluster you will need to use other synchronization mechanisms than just a synchronized block.

<!-- https://jenkov.com/tutorials/java-concurrency/synchronized.html -->

<!-- https://jenkov.com/tutorials/java-concurrency/starvation-and-fairness.html -->

<!-- https://jenkov.com/tutorials/java-concurrency/nested-monitor-lockout.html -->