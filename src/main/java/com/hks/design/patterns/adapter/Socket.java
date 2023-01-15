package com.hks.design.patterns.adapter;

public class Socket {
    public Volt getVolts(){
        return new Volt(120);
    }
}
