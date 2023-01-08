package com.hks.design.patterns.factory;

import com.hks.design.patterns.factory.factory.ComputerFactory;
import com.hks.design.patterns.model.Computer;

public class TestFactory {
    public static void main(String[] args) {
        Computer pc = ComputerFactory.getComputer("pc", "2 GB", "500 GB", "2.4 GHz");
        Computer server = ComputerFactory.getComputer("server", "16 GB", "1 TB", "2.9 GHz");
        System.out.println("Factory PC config: " + pc);
        System.out.println("Factory server config: " + server);
    }
}
