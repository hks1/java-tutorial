package com.tutorial.concurrency;

import java.util.HashSet;

class ObservableSetTest {
    public static void main(String[] args) {
        ObservableSet<Integer> set = new ObservableSet<>(new HashSet<>());

        set.addObserver((new SetObserver<Integer>() {
            public void added(ObservableSet<Integer> s, Integer e) {
                System.out.println(e); // action
                /*
                if(e > 25){  // too many to observe
                    s.removeObserver(this);
                }

                 */
            }
        }));

        for (int i = 0; i < 100; i++) {
            set.add(i);
        }
    }
}
