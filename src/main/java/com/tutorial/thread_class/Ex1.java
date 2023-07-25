package com.tutorial.thread_class;

// https://stackoverflow.com/questions/877096/how-can-i-pass-a-parameter-to-a-java-thread
public class Ex1 {
    public static void main(String[] args) {
        final int patameter = 10;
        final String str = "string to pass to thread";

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("integer parameter: " + patameter);
                System.out.println("str: " + str);
            }
        });
        thread.start();
    }
}
