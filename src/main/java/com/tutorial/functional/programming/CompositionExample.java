package com.tutorial.functional.programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompositionExample {
    protected static class Employee{
        public final String name;
        public final Integer age;
        public final String jobTitle;
        public final Float salary;

        public Employee(String name, Integer age, String jobTitle, Float salary){
            this.name = name;
            this.age = age;
            this.jobTitle = jobTitle;
            this.salary = salary;
        }
    }

    public static void main(String[] args) {
        Function<Integer, Integer> timesTwo = x -> x * 2;
        Function<Integer, Integer> minusOne = x -> x - 1;
        /*
        // compose works in reverse order, i.e., in following example [minusOne.compose(timesTwo)], timesTwo is called first and then minusOne
        Function<Integer, Integer> timesTwoMinusOne = minusOne.compose(timesTwo);
        Function<Integer, Integer> minusOneTimeTwo = timesTwo.compose(minusOne);
        System.out.println(timesTwoMinusOne.apply(5));
        System.out.println(minusOneTimeTwo.apply(5));

         */
        Function<Integer, Integer> timesTwoMinusOne = timesTwo.andThen(minusOne);
        System.out.println(timesTwoMinusOne.apply(5));

        Employee[] employeesArr = {
                new Employee("John", 34, "developer", 80000f),
                new Employee("Hannah", 24, "developer", 95000f),
                new Employee("Bart", 50, "sales executive", 100000f),
                new Employee("Sophie", 49, "construction worker", 40000f),
                new Employee("Darren", 38, "writer", 50000f),
                new Employee("Nancy", 29, "developer", 75000f),
        };
        List<Employee> employees = new ArrayList<>(Arrays.asList(employeesArr));

        Function<Employee, String> getName = employee -> employee.name;
        Function<String, String> reverse = str -> new StringBuilder(str).reverse().toString();
        Function<String, String> uppercase = str -> str.toUpperCase(Locale.ROOT);

        Function<Employee, String> getReversedUpperCasedName = getName.andThen(reverse).andThen(uppercase);

        List<String> results = employees
                .stream()
                .map(getReversedUpperCasedName)
                .collect(Collectors.toList());

        System.out.println(results);



    }
}
