package com.tutorial.java.path;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class FileCopyExample {

    public static void main(String[] args) {
        Path source = Paths.get("C:\\Users\\hshukla\\Desktop\\FileCreationEx.txt");
        Path dest = Paths.get("C:\\Users\\hshukla\\Desktop\\FileCopyEx.txt"); // creates if doesn't exist

        /*try{
            Files.copy(source, dest);
        } catch (IOException e){
            e.printStackTrace();
        }*/

        // additional options with Files.copy()
        try{
            Files.copy(source, dest, REPLACE_EXISTING);
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
