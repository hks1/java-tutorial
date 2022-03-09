package com.tutorial.collections.sorting;

import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return (int) (o1.getEmployeeId() - o2.getEmployeeId());
    }
}
