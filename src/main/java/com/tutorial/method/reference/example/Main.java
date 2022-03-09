package com.tutorial.method.reference.example;

public class Main {

    public static void main(String[] args) {
        Square s = new Square(4);

        Shapes shapes = (Square square) -> {
            return square.calculateArea();
        };

        System.out.println("Area: " + shapes.getArea(s));

        // method reference

        Shapes shapes1 = Square::calculateArea;

        System.out.println("Area: " + shapes.getArea(s));
    }
}
