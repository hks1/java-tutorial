package com.hks.design.patterns.builder;

public class TestBuilderPattern {
    public static void main(String[] args) {
        // Using builder to get the object,
        // without any inconsistent state or arguments management issues
        Computer computer = new Computer.ComputerBuilder("500 GB", "2 GB")
                .setBluetoothEnabled(true)
                .setGraphicsCardEnabled(true)
                .build();
        System.out.println(computer);
    }
}
