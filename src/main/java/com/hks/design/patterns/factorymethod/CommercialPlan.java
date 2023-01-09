package com.hks.design.patterns.factorymethod;

public class CommercialPlan extends Plan{
    @Override
    void getRate() {
        rate = 7.50;
    }
}
