package com.patterns;

public class ProxyPattern {
}

abstract class Greeter{
    abstract String greet();
}

class RealGreeter extends Greeter{
    String greet(){ return "Hi there!";}
}

class GreeterProxy extends Greeter{
    // Virtual Proxy that has a reference to RealGreeter
    // not all proxies necessarily have reference
    Greeter greeter;

    @Override
    String greet() {
        // Lookup greeter object on network
        // send request to call "greet()" method
        // OR
        // check if user is authorized
        if(greeter == null) greeter = new RealGreeter();
        return greeter.greet();
        //return null;
    }
}

class TestProxyPattern{
    public static void main(String[] args) {
        Greeter greeter = new GreeterProxy();
        greeter.greet();
        System.out.println(greeter.greet());
    }
}

