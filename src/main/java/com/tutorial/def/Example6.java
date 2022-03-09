package com.tutorial.def;

public class Example6 {
    public static class Vehicle{
        String tag;

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            System.out.println("Vehicle::setTag()");
            this.tag = tag;
        }
    }

    public static class Car extends Vehicle{
        String Make;

        public void setMake(String make) {
            Make = make;
        }

        public String getMake() {
            return Make;
        }

        @Override
        public void setTag(String tag) {
            //super.setTag(tag);
            System.out.println("Car::setTag()");
            this.tag = tag.toLowerCase();
        }
    }

    public static void main(String[] args) {
        Car car = new Car();
        Vehicle vehicle = car;
        car.setTag("CAR-TAGg");
        //vehicle.setTag("CAR-TAGg");
        System.out.println(car.getTag());
        System.out.println(vehicle.getTag());
    }
}
