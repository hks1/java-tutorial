package com.tutorial.java.records;



public record Vehicle2 (String brand, String licensePlate){

    // It is possible to add other constructors to a Record

    public Vehicle2(String brand){
        this(brand, null);
    }

    // It is also possible to add extra instance method to a Record
    public String brandAsLowerCase(){
        return this.brand.toLowerCase();
    }

    // it is also possible to add static method to a Record
    public static String brandAsUpperCase(Vehicle2 vehicle){
        return vehicle.brand.toUpperCase();
    }
}
