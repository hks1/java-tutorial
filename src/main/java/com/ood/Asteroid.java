package com.ood;

public class Asteroid implements Moveable, Drawable{

    @Override
    public void move(int x, int y) {
        System.out.println("x: " + x +", y: " + y);
    }

    @Override
    public void draw() {

    }
}
