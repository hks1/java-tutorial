package com.tutorial.collections.collection.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Implement a Comparator using Java Lambda::::
public class ListSortEx3 {

    public static void main(String[] args) {
        System.out.println("Implement a Comparator using Java Lambda::::");

        //Car car = new Car("RAM", "123", 2);

        List<Car> list = new ArrayList<>();

        list.add(new Car("Volvo V40" , "XYZ 201845", 5));
        list.add(new Car("Citroen C1", "ABC 164521", 4));
        list.add(new Car("Dodge Ram" , "KLM 845990", 2));

        Comparator<Car> carBrandComparatorLambda =
                (car1, car2) -> car1.brand.compareTo(car2.brand);

        Comparator<Car> carNumberPlateComparatorLambda =
                (car1, car2) -> car1.numberPlate.compareTo(car2.numberPlate);

        Comparator<Car> carNoOfDoorsComparatorLambda =
                (car1, car2) -> car1.noOfDoors - car2.noOfDoors;

        System.out.println("Sort by Brand::");
        Collections.sort(list, carBrandComparatorLambda);
        for (Car car : list) {
            System.out.println(car.brand);
        }

        System.out.println("Sort by No of Doors::");
        Collections.sort(list, carNoOfDoorsComparatorLambda);
        for (Car car : list) {
            System.out.println(car.noOfDoors);
        }

        System.out.println("Sort by Number Plate::");
        Collections.sort(list, carNumberPlateComparatorLambda);
        for (Car car : list) {
            System.out.println(car.numberPlate);
        }
    }
}


