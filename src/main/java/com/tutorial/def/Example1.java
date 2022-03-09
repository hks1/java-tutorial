package com.tutorial.def;

import java.util.Comparator;

public class Example1 {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Xander", 1);
        Employee emp2 = new Employee("Jon", 3);
        Employee emp3 = new Employee("Greta", 2);
        Employee emp4 = new Employee("Greta", 4);

        Employee[] employees = {emp1, emp2, emp3, emp4};

        System.out.println("Comparator:: sort by name");

        java.util.Arrays.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.name.compareTo(o2.name);
            }
        });

        //System.out.println(java.util.Arrays.toString(employees));
        for (Employee emp :
                employees) {
            System.out.println(emp.name + " : " + emp.id);
        }

        System.out.println("Comparator:: sort by id");

        java.util.Arrays.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.id - o2.id;
            }
        });

        for (Employee emp :
                employees) {
            System.out.println(emp.name + " : " + emp.id);
        }

        System.out.println("Comparator:: sort by name and then by id, if name is same");

        java.util.Arrays.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                int nameDiff = o1.name.compareTo(o2.name);
                if(nameDiff != 0) return nameDiff;

                return o1.id - o2.id;
            }
        });

        for (Employee emp :
                employees) {
            System.out.println(emp.name + " : " + emp.id);
        }
    }
}

class Employee{
    public String name;
    public int id;

    Employee(String name, int id){
        this.name = name;
        this.id = id;
    }
}
