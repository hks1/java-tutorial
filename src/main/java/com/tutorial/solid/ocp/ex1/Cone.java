package com.tutorial.solid.ocp.ex1;

public class Cone extends VolumeCalculator{
    private int radius;
    private int height;

    public Cone(int radius, int height){
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double volume() {
        return Math.PI * Math.pow(radius, 2) * (height/3);
    }
}
