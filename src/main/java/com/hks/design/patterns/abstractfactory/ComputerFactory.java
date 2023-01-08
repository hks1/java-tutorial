package com.hks.design.patterns.abstractfactory;

import com.hks.design.patterns.model.Computer;

public class ComputerFactory {

    public static Computer getComputer(ComputerAbstractFactory factory){
        return factory.createComputer();
    }
}
