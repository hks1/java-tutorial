package com.tutorial.solid.ocp.ex1;

public class Cuboid extends VolumeCalculator{
    private int length;
    private int width;
    private int height;

    public Cuboid(int length, int width, int height){
        this.length = length;
        this.width = width;
        this.height = height;
    }

    @Override
    public double volume() {
        return length * width * height;
    }
}
