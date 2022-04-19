package com.tutorial.java.files;

import java.io.File;
import java.io.IOException;

public class FileCreationExample {

    public static void main(String[] args) {
        //below statement creates an object only, file will not be created yet
        File myFile = new File("C:\\Users\\hshukla\\Desktop\\FileCreationEx.txt");
        // Creating the file on disk now
        try {
            boolean fileCreated = myFile.createNewFile(); // returns boolean
            System.out.println(fileCreated);
        } catch (IOException e){
            System.out.println(e);
        }
        // the File class does not come with functionality to read and write to it.
    }
}
