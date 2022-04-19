package com.tutorial.java.path;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathClassExample {

    public static void main(String[] args) {
        Path path = Paths.get("myDirectory_testdirectorycreation"); // directory created in DirectoriesExample
        try{
            Files.deleteIfExists(path);
        } catch(IOException e){

        }

        Path path1 = Paths.get("C:\\Users\\hshukla\\Desktop\\FileCreationEx.txt");
        System.out.println(path1.getParent());
        System.out.println(path1.getRoot());
        System.out.println(path1.getFileName());
    }
}
