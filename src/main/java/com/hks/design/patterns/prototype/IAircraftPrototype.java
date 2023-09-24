package com.hks.design.patterns.prototype;

public interface IAircraftPrototype {
    void fly();
    IAircraftPrototype clone();
    void setEngine(F16Engine f16Engine);
}
