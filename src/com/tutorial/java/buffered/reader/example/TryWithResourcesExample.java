package com.tutorial.java.buffered.reader.example;

// try-with-resources

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class TryWithResourcesExample {
    public static void main(String[] args) {
        // Objects that implements the auto-closable interface are resources.
        // implementation without 'try-with-resources'
         /*try {
             BufferedReader reader = new BufferedReader(new StringReader("Hello String!!!"));
             StringWriter writer = new StringWriter();
             writer.write(reader.readLine());
             System.out.println(writer.toString());
         } catch(IOException e){
             System.out.println(e);
         }*/

        // try-with-resources - automatically closes resources to prevent resource leaks
        // - it's a simple, easy and effective way to prevent resource leaks
        // Objects that implements the auto-closable interface are resources.
        try(
                BufferedReader reader = new BufferedReader(new StringReader("Hellllo String!!!"));
                StringWriter writer = new StringWriter();
                ) {
            writer.write(reader.readLine());
            System.out.println(writer.toString());
        } catch(IOException e){

        }
    }
}
