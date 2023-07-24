package com.tutorial.patterns;

public class StrategyPattern {
}

class File1{

    CompressionStrategy strategy;

    void compress(){

    }
}

abstract class CompressionStrategy{
    abstract void compress();
}

class ZipCompression extends CompressionStrategy{
    @Override
    void compress() {
        System.out.println("Compression with ZIP");
    }
}

class RarCompression extends CompressionStrategy{
    @Override
    void compress() {
        System.out.println("Compressoin with RAR");
    }
}

class TestStrategyPattern{
    public static void main(String[] args) {
        File1 f = new File1();
        f.strategy = new ZipCompression();
        f.compress();
    }
}
