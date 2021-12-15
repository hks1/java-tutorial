package com.tutorial.java.deadlock_example;

public class Kitchen {

    public static Object spoon = new Object();
    public static Object bowl = new Object();

    public static void main(String[] args) {

        Thread cook1 = new Thread(() -> {
            synchronized (spoon) {
                System.out.println("Cook1: Holding the spoon...");
                System.out.println("Cook1: waiting for the bowl...");

                synchronized (bowl) {
                    System.out.println("Cook1: Holding the spoon and the bowl");
                }
            }
        });

        Thread cook2 = new Thread(() -> {
            synchronized (bowl) {
                System.out.println("Cook1: Holding the bowl...");
                System.out.println("Cook1: waiting for the spoon...");

                synchronized (spoon) {
                    System.out.println("Cook1: Holding the bowl and the spoon");
                }
            }
        });

        cook1.start();
        cook2.start();

    }
}
