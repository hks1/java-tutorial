package com.tutorial.java.scanner.example;

public class Person {

    private String name;
    private int age;
    private long phoneNUmber;

    public Person(String name, int age, long phoneNUmber) {
        this.name = name;
        this.age = age;
        this.phoneNUmber = phoneNUmber;
        System.out.println("Person Created. Name='" + name + '\'' +
                ", Age=" + age +
                ", phone nUmber=" + phoneNUmber);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phoneNUmber=" + phoneNUmber +
                '}';
    }
}
