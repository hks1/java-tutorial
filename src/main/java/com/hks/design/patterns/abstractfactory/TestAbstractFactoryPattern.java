package com.hks.design.patterns.abstractfactory;

import com.hks.design.patterns.model.Computer;
import com.hks.design.patterns.model.PC;

public class TestAbstractFactoryPattern {
    public static void main(String[] args) {
        testAbstractFactory();
    }

    private static void testAbstractFactory(){
        Computer pc = ComputerFactory.getComputer(new PCFactory("2 GB", "500 GB", "2.4 GHz"));
        Computer server = ComputerFactory.getComputer(new ServerFactory("16 GB", "1 B", "2.9 GHz"));
        System.out.println("AbstractFactory PC config: " + pc);
        System.out.println("AbstractFactory Server config: " + server);
    }
}
