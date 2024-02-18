package com.tutorial.solid.ocp.ex1;

public class Main {
    public static void main(String[] args) {
        VolumeCalculator cone = new Cone(2,3);

        System.out.println(cone.volume());

        VolumeCalculator cuboid = new Cuboid(2,3,4);
        System.out.println(cuboid.volume());
    }
}
