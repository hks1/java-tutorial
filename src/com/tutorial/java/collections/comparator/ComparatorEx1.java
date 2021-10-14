package com.tutorial.java.collections.comparator;

import com.tutorial.java.collections.collection.queue.Customer;
import com.tutorial.java.collections.sorting.Employee;

import java.util.Comparator;

public class ComparatorEx1 implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return (int) (o1.getEmployeeId() - o2.getEmployeeId());
    }

}

class Main{

    public static void main(String[] args) {
        Employee e1 = new Employee("first", "last");
        Employee e2 = new Employee("Jane", "Marie");

        System.out.println(e1.equals(e2));
    }


}
