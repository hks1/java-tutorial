package com.tutorial.collections.collection.map.properties;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Properties;

public class PropertiesExample1 {
    public static void main(String[] args) {
        // Create Properties instance
        Properties properties = new Properties();
        // Set Property
        properties.setProperty("email", "demo@hks.com");
        // Get Property
        String email = properties.getProperty("email");
        properties.setProperty("first name", "John Doe");
        System.out.println(properties);
        // Remove Property
        properties.remove("first name");
        System.out.println("after removing proprty  - first name " + properties);
        properties.setProperty("key1", "value1");
        properties.setProperty("key2", "value2");
        properties.setProperty("key3", "value3");
        properties.setProperty("key4", "value4");

        // Iterate Properties
        Iterator keyIterator = properties.keySet().iterator();
        while (keyIterator.hasNext()){
            String key = (String) keyIterator.next();
            String value = properties.getProperty(key);
            System.out.println(key + " : " + value);
        }

        // Store properties to file
        try(FileWriter output = new FileWriter("props.properties", Charset.forName("UTF-8"))){
            properties.store(output, "These are properties");
        } catch (IOException e){
            e.printStackTrace();
        }

        // Load properties from file
        try(FileReader fileReader = new FileReader("props.properties")){
            properties.load(fileReader);
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
