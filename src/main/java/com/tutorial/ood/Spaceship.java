package com.tutorial.ood;

public class Spaceship implements Moveable, Drawable {

    // instance variables
    public String callSign;
    private int shieldStrength;

    // class variables
    public static float toughness;

    // constructor method
    public Spaceship(){
        callSign = "The nameless ship";
        shieldStrength = 100;
    }

    // overload constructor
    public Spaceship(String name){
        callSign = name;
        shieldStrength = 200;
    }

    // public static methods - can only access static variables
    public  static void increaseDifficulty(float t){
        toughness += t;
    }

    public void setShieldStrength(int s)
    {
        this.shieldStrength = s;
    }

    @Override
    public void move(int x, int y) {
        System.out.println("x: " + x + ", y:" + y);
    }

    @Override
    public void draw() {

    }
}

class CargoShuttle extends Spaceship{
    public CargoShuttle(String name){
        super(name);
    }

    @Override
    public void setShieldStrength(int s) {
        super.setShieldStrength(s);
    }
}

class StarFighter extends Spaceship{
    public StarFighter(String name){
        super(name);
    }

    @Override
    public void setShieldStrength(int s) {
        super.setShieldStrength(s);
    }
}

class TDSpaceship{
    public static void main(String[] args) {
        Spaceship myShip = new Spaceship();
        System.out.println(myShip.callSign);
        System.out.println(Spaceship.toughness);
        Spaceship.increaseDifficulty(0.85f);
        System.out.println(Spaceship.toughness);
        CargoShuttle cargo = new CargoShuttle("valid car-go");
        System.out.println(cargo.callSign);
        cargo.increaseDifficulty(.6f);
        System.out.println(CargoShuttle.toughness);
    }
}
