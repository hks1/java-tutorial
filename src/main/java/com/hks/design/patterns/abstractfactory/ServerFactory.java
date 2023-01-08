package com.hks.design.patterns.abstractfactory;

import com.hks.design.patterns.model.Computer;
import com.hks.design.patterns.model.Server;

public class ServerFactory implements ComputerAbstractFactory{

    private String cpu;
    private String ram;
    private String hdd;

    public ServerFactory(String ram, String hdd, String cpu){
        this.cpu = cpu;
        this.ram = ram;
        this.hdd = hdd;
    }

    @Override
    public Computer createComputer() {
        return new Server(ram, hdd, cpu);
    }
}
