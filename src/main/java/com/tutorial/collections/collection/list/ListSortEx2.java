package com.tutorial.collections.collection.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListSortEx2 {

    public static void main(String[] args) {
        System.out.println("Sort List using Comparator:::");

        List<Car> list = new ArrayList<>();

        list.add(new Car("Honda", "123 XYZ", 4));
        list.add(new Car("Toyota", "456 ABC", 2));
        list.add(new Car("GM", "789 RET", 4));

        Comparator<Car> carBrandComparator = new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.brand.compareTo(o2.brand);
            }
        };

        Collections.sort(list, carBrandComparator);

        for (Car car : list) {
            System.out.println(car.brand);
        }
    }
}

class Car{
    public String brand;
    public String numberPlate;
    public int noOfDoors;

    public Car(String brand, String numberPlate, int noOfDoors){
        this.brand = brand;
        this.noOfDoors = noOfDoors;
        this.numberPlate = numberPlate;
    }
}
