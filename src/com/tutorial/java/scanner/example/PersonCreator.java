package com.tutorial.java.scanner.example;

import java.util.Scanner;

public class PersonCreator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*System.out.print("enter the name: ");
        String name = scanner.next();
        System.out.print("enter the age: ");
        int age = scanner.nextInt();
        System.out.print("Enter a phone number: ");
        Long phoneNumber = scanner.nextLong();*/

        System.out.print("enter the name, age and phone number: ");
        String name = scanner.next();
        int age = scanner.nextInt();
        Long phoneNumber = scanner.nextLong();

        Person person = new Person(name, age, phoneNumber);
    }
}
