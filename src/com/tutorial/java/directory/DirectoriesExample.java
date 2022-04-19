package com.tutorial.java.directory;

import java.io.File;
import java.io.FilenameFilter;

public class DirectoriesExample {
    public static void main(String[] args) {
        // list everything inside a directory
        String[] contents = new File(".").list();
        /*for (String file: contents){
            System.out.println(file);
        }*/
        // create directory
        new File("myDirectory_testdirectorycreation").mkdir();

        // filter file list - not to include directories
        FilenameFilter filter = (file, fileName) -> {
            return fileName.contains(".");
        };
        // Storing filtered contents
        String[] filteredContents = new File(".").list(filter);
        for(String file: filteredContents){
            System.out.println(file);
        }
    }
}
