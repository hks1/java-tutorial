package com.hks.design.patterns.factorymethod;

public class DomesticPlan extends Plan{

    @Override
    void getRate() {
        rate = 3.50;
    }
}
