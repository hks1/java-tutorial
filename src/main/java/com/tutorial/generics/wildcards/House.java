package com.tutorial.generics.wildcards;

public class House extends Building{

    public int numberOfRooms = 11;

    @Override
    public String toString() {
        return "House{" +
                "numberOfRooms=" + numberOfRooms +
                '}';
    }

    @Override
    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    @Override
    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }
}
