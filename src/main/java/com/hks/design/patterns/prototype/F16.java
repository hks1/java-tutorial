package com.hks.design.patterns.prototype;

public class F16 implements IAircraftPrototype{
    // default engine
    F16Engine engine = new F16Engine();

    @Override
    public void fly() {
        System.out.println("F-16 flying...");
    }

    @Override
    public IAircraftPrototype clone() {
        // deep clone self and return the product
        return new F16();
    }

    @Override
    public void setEngine(F16Engine engine) {
        this.engine = engine;
    }
}
