package com.tutorial.scanner.example;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class TestReadFile {
    ReadFile obj;
    @BeforeEach
    public void setUp(){
        obj = new ReadFile();
    }
    @Test
    public void testRead(){
        obj = new ReadFile();
        String path = "C:/workspace/java/states.txt";
        //String path = "C:/workspace/java/animals.txt";
        obj.read(path);
        //System.out.println(obj.read(path).size());
        //obj.read(path).stream().forEach(System.out::println);
    }
}
