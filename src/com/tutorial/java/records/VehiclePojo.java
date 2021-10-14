package com.tutorial.java.records;

public class VehiclePojo {
    private String brand = null;
    protected String licensePlate = null;

    public VehiclePojo(String brand, String licensePlate){
        this.brand  =brand;
        this.licensePlate = licensePlate;
    }

    public String getBrand() {
        return brand;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    @Override
    public int hashCode(){
        return this.brand.hashCode() * this.licensePlate.hashCode();
    }

    public boolean equals(Object other){
        if(other == null){
            return false;
        }
        if(!(other instanceof VehiclePojo)){
            return false;
        }

        VehiclePojo otherVehicle = (VehiclePojo) other;

        return this.brand.equals(otherVehicle.getBrand()) &&
                this.licensePlate.equals(otherVehicle.getLicensePlate());
    }

    @Override
    public String toString() {
        return "VehiclePojo{" +
                "brand='" + brand + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                '}';
    }
}
