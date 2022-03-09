package com.tutorial.lambda;

import java.io.IOException;
import java.io.OutputStream;

// An interface can have default an static methods and lambda expression can still implement it,
    // as long as there is only one abstract/un-implemented method in the interface

public interface MyInterface {
    void printIt(String text);

    default public void printUTF8To(String text, OutputStream outputStream){
        try{
            outputStream.write(text.getBytes("UTF-8"));
        } catch (IOException e){
            throw new RuntimeException("Error writing String as UTF-8 to OutputStream", e);
        }
    }

    static void printItToSystemOut(String text){
        System.out.println(text);
    }
}

// LambdaExample3
