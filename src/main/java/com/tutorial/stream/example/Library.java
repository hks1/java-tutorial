package com.tutorial.stream.example;

import java.util.ArrayList;

public class Library {

    public static void main(String[] args) {
        ArrayList<Book> books = populateLibrary();

        // filter() is a lazy method, and forEach() is an eager method
        // there can be more than one lazy methods but only one eager method
        books.stream().filter(book -> {
            return book.getAuthor().startsWith("J");
        }).filter(book -> {
            return book.getTitle().startsWith("E");
        }).forEach(System.out::println);

        // parallel streams - makes use of multiple cores
        books.parallelStream().filter(book -> {
            return book.getAuthor().startsWith("J");
        }).forEach(System.out::println);

    }

    static ArrayList<Book> populateLibrary() {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Johny Mason not real", "Going Wild"));
        books.add(new Book("Emmy Parker not real", "Another Day"));
        books.add(new Book("Jane Austen", "Emma"));
        books.add(new Book("Jane Austen", "Pride and Prejudice"));
        books.add(new Book("Jane Austen", "Persuasion"));
        books.add(new Book("Jane Austen", "Mansfield Park"));
        return books;
    }
}
