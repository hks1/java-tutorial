package com.hks.design.patterns.adapter;

public class MovableAdapterImpl implements MovableAdapter{
    private Movable vehicle;

    // standard constructor
    public MovableAdapterImpl(Movable movable){
        this.vehicle = movable;
    }

    @Override
    public double getSpeed() {
        return convertMPHtoKMPH(vehicle.getSpeed());
    }

    public double convertMPHtoKMPH(double mph){
        return mph * 1.60934;
    }
}
