package com.tutorial.java.collections.comparable;

public class Rectangle implements Comparable<Rectangle>{
    protected int length;
    protected int width;

    Rectangle(int length, int width){
        this.length = length;
        this.width = width;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "length=" + length +
                ", width=" + width +
                '}';
    }

    @Override
    public int compareTo(Rectangle o) {
        if(this.length == o.length && this.width == o.width) return 0;
        return this.length*this.width - o.length*o.width;
    }
}
