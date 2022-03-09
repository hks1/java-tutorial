package com.tutorial.collections.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingExample2 {
    public static void main(String[] args) {

        // Sorting Objects Using a Comparator

        List<Employee> employees = new ArrayList<>();

        Employee employee = new Employee("John", "Doe");
        employee.setEmployeeId(501);
        Employee employee1 = new Employee("Sara", "Lee");
        employee1.setEmployeeId(601);
        //System.out.println(employee.equals(employee1));
        System.out.println(employee);

        employees.add(employee);
        employees.add(employee1);
        employees.add(new Employee("Annie", "Mason", 401));

        EmployeeComparator employeeComparator = new EmployeeComparator();

        System.out.println("employees list : " + employees);
        Collections.sort(employees, employeeComparator);
        System.out.println("sorted employees list (using custom Comparator) : " + employees);
    }
}
