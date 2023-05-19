package com.hks.design.patterns.singleton;

import java.io.Serializable;

public class DemoSingleton implements Serializable {
    private static volatile DemoSingleton instance = null;

    private DemoSingleton(){}

    public static DemoSingleton getInstance() {
        if(instance == null){
            instance = new DemoSingleton();
        }
        return instance;
    }
    private int i = 10;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}
