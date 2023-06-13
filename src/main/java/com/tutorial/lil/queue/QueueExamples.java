package com.tutorial.lil.queue;

import javax.swing.plaf.IconUIResource;
import java.util.LinkedList;
import java.util.Queue;

public class QueueExamples {
    public void printBinary(int n){
        if(n <= 0){
            System.out.println();
            return;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        for (int i = 0; i < n; i++) {
            int current = queue.remove();
            System.out.println(current);

            queue.add(current * 10);
            queue.add(current * 10 + 1);
        }
        System.out.println();
    }
}

class QETD{
    public static void main(String[] args) {
        QueueExamples obj = new QueueExamples();

        obj.printBinary(9);
        obj.printBinary(-5);
    }
}