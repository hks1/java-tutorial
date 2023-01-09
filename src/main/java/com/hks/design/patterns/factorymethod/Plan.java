package com.hks.design.patterns.factorymethod;

// calculate electricity bill - example of Factory Method

public abstract class Plan {
    protected double rate;
    abstract void getRate();

    public void calculateRate(int units){
        System.out.println("rate is : " + units * rate);
    }
}
