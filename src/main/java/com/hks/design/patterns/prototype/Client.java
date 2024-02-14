package com.hks.design.patterns.prototype;

public class Client {
    public static void main(String[] args) {
        IAircraftPrototype prototype = new F16();

        // create F16-A
        IAircraftPrototype f16A = prototype.clone();
        f16A.setEngine(new F16AEngine());

        // create F16-B
        IAircraftPrototype f16B = prototype.clone();
        f16B.setEngine(new F16BEngine());
    }

}

class F16AEngine extends F16Engine {

}

class F16BEngine extends F16Engine {

}
