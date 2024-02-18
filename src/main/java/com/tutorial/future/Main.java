package com.tutorial.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        SquareCalculator squareCalculator = new SquareCalculator();

        //Future<Integer> future = new SquareCalculator().calculate(10);
        Future<Integer> future = squareCalculator.calculate(10);

        /*while (!future.isDone()){
            System.out.println("Still running...");
            Thread.sleep(300);
        }*/

        int result = future.get();
        System.out.println(result);
        System.out.println(future.state().toString());




// Our current ExecutorService is single threaded,
// since it was obtained with the Executors.newSingleThreadExecutor.
// To highlight this single thread, let's trigger two calculations simultaneously:


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

        System.out.println("str1" + "str2");
        String str1 = "str1";
        String str2 = "str2";
        String str3 = str1 + str2;
        System.out.println(str3);
    }
}
