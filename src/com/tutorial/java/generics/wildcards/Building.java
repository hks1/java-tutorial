package com.tutorial.java.generics.wildcards;

public class Building {

    public int numberOfRooms = 9;

    @Override
    public String toString() {
        return ("building");
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }
}
