package com.patterns;

public class SingletonPattern {
}

class Throttler{
    // make constructor private
    public static final Throttler INSTANCE = new Throttler();
    private Throttler() {throw new AssertionError();}
    public void throttle() { /*...*/}
}

// Singleton considered harmful
