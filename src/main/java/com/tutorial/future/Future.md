// Future

# Futures
the _Future_ class represents a future result of an asynchronous computation. 
This result will eventually appear in the Future after the processing is complete.

# Implementing _Futures_ with _FutureTask_

FutureTask is an implementation of Future interface.

```java
public class EventLoggingTask implements  Runnable{
    private Logger logger
      = LoggerFactory.getLogger(EventLoggingTask.class);

    @Override
    public void run() {
        logger.info("Message");
    }
}
```

- Callable
- ExecutorService

_Callable_ is an interface representing a task that returns a result, and has a single _call()_ method.

Creating an instance of _Callable_ doesn't take us anywhere; 
we still have to pass this instance to an executor that will take care of starting the task in a new thread, 
and give us back the valuable _Future_ object. 
That's where _ExecutorService_ comes in.

There are a few ways we can access an _ExecutorService_ instance, 
and most of them are provided by the utility class _Executors‘_ static factory methods.

In above example, we used the basic _newSingleThreadExecutor()_, 
which gives us an _ExecutorService_ capable of handling a single thread at a time.

Once we have an _ExecutorService_ object, we just need to call _submit()_, 
passing our _Callable_ as an argument. 
Then _submit()_ will start the task and return a _FutureTask_ object, 
which is an implementation of the _Future_ interface.

# Consuming Futures

## _isDone()_ and _get()_ to obtain results

```java
Future<Integer> future = new SquareCalculator().calculate(10);

while(!future.isDone()) {
    System.out.println("Calculating...");
    Thread.sleep(300);
}

Integer result = future.get();
```

The method get() will block the execution until the task is complete. Again, this won't be an issue because in our example, get() will only be called after making sure that the task is finished. So in this scenario, future.get() will always return immediately.

It's worth mentioning that get() has an overloaded version that takes a timeout and a TimeUnit as arguments:

```java
Integer result = future.get(500, TimeUnit.MILLISECONDS);
```

The difference between _get(long, TimeUnit)_ and _get()_ is that the former will throw a _TimeoutException_ if the task doesn't return before the specified timeout period.

# canceling a _Future_ with _cancel()_
```java
Future<Integer> future = new SquareCalculator().calculate(4);

boolean canceled = future.cancel(true);
// outcome of get() now will be CancellationException exception
```

It's also possible that a call to cancel() fails. In that case, 
the returned value will be false. 
It's important to note that cancel() takes a boolean value as an argument. 
This controls whether the thread executing the task should be interrupted or not.

# more multithreading with _Thread_ Pools
```java
SquareCalculator squareCalculator = new SquareCalculator();

Future<Integer> future1 = squareCalculator.calculate(10);
Future<Integer> future2 = squareCalculator.calculate(100);

while (!(future1.isDone() && future2.isDone())) {
    System.out.println(
      String.format(
        "future1 is %s and future2 is %s", 
        future1.isDone() ? "done" : "not done", 
        future2.isDone() ? "done" : "not done"
      )
    );
    Thread.sleep(300);
}

Integer result1 = future1.get();
Integer result2 = future2.get();

System.out.println(result1 + " and " + result2);

squareCalculator.shutdown();
```

**Executors.newFixedThreadPool()**
```java
public class SquareCalculator {
 
    private ExecutorService executor = Executors.newFixedThreadPool(2);
    
    //...
}
```

This is looking much better now. We can see that the 2 tasks start and finish running simultaneously, and the whole process takes around 1 second to complete.

There are other factory methods that can be used to create thread pools,like 
</br>**Executors.newCachedThreadPool()**, which reuses previously used Threads when they're available, and
</br>**Executors.newScheduledThreadPool()**, which schedules commands to run after a given delay.

# ForkJoinTask

**TBD**
<!-- https://www.baeldung.com/java-future -->

```java
public class FactorialSquareCalculator extends RecursiveTask<Integer> {
 
    private Integer n;

    public FactorialSquareCalculator(Integer n) {
        this.n = n;
    }

    @Override
    protected Integer compute() {
        if (n <= 1) {
            return n;
        }

        FactorialSquareCalculator calculator 
          = new FactorialSquareCalculator(n - 1);

        calculator.fork();

        return n * n + calculator.join();
    }
}
```

```java
ForkJoinPool forkJoinPool = new ForkJoinPool();

FactorialSquareCalculator calculator = new FactorialSquareCalculator(10);

forkJoinPool.execute(calculator);
```

-- Callable vs Runnable
<!-- https://www.baeldung.com/java-runnable-callable -->

