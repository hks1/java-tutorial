package com.tutorial.java.records;

public class RecordsExample {
    public static void main(String[] args) {
        String brand = "Mercedes";
        String licensePlate = "ATV 123";

        VehiclePojo vehicle = new VehiclePojo(brand, licensePlate);

        System.out.println(vehicle.getBrand());
        System.out.println(vehicle.getLicensePlate());

        System.out.println(vehicle.toString());

        // Same implementation using Java Record, implemented in Vehicle1.java
        System.out.println("Implementation using Java Record:::");

        Vehicle1 vehicle1 = new Vehicle1(brand, licensePlate);
        System.out.println(vehicle1.brand());
        System.out.println(vehicle1.licensePlate());
        System.out.println(vehicle1);

        Vehicle1 vehicle11 = new Vehicle1("Mercedes", "ATV 123");
        System.out.println(vehicle1.equals(vehicle11));

        Vehicle2 vehicle2 = new Vehicle2("BMW");
        System.out.println(vehicle2);

        Vehicle2 vehicle21 = new Vehicle2("Ferrari");

        String brandAsLowerCase = vehicle2.brandAsLowerCase();
        System.out.println(brandAsLowerCase);

        String brandAsUpperCase = Vehicle2.brandAsUpperCase(vehicle21);
        System.out.println(brandAsUpperCase);
    }
}
