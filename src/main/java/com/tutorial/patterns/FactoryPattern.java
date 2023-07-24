package com.tutorial.patterns;

class CreationalPattern {
}

// Factory Method Pattern
// Abstract Factory Pattern
// Singleton

class ZipCompressionStrategy extends CompressionStrategy {
    @Override
    void compress() {

    }
}

class RarCompressionStrategy extends CompressionStrategy{
    @Override
    void compress() {

    }
}

abstract class CompressionStrategyFactory{
    abstract CompressionStrategy create();
}

class ZipCompressionStrategyFactory extends CompressionStrategyFactory{
    @Override
    CompressionStrategy create() {
        return new ZipCompressionStrategy();
    }
}

class RarCompressoinStrategyFactory extends CompressionStrategyFactory{
    @Override
    CompressionStrategy create() {
        return new RarCompressionStrategy();
    }
}

class TestPatterns{
    public static void main(String[] args) {
        CompressionStrategyFactory factory = new ZipCompressionStrategyFactory();
        System.out.println(factory.create());
    }
}