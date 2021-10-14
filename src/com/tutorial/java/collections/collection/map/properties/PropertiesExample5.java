package com.tutorial.java.collections.collection.map.properties;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesExample5 {
    public static void main(String[] args) {
        // Default values with getProperty()
        Properties properties = new Properties();

        String preferredLanguage = properties.getProperty("PreferredLanguage", "Hindi");

        System.out.println(preferredLanguage);

        // Default Values With a Default Properties Instance
        Properties defaultProperties = new Properties();
        defaultProperties.setProperty("preferredLanguage", "Hindi");

        Properties newProperties = new Properties(defaultProperties);
        String language = newProperties.getProperty("preferredLanguage");

        System.out.println("Preferred Language : " + language);

        // System Properties
        Properties systemProperties = System.getProperties();
        System.out.println("System Properties : " + systemProperties);
        System.setProperty("key1", "value1");
        systemProperties.setProperty("key2", "value2");

        try(FileOutputStream outputStream = new FileOutputStream("systemm.properties")){
            systemProperties.store(outputStream, "System Properties");
        } catch(IOException e){
            e.printStackTrace();
        }

        // Setting Java System Properties via the Command Line
            // java -Dkey1=value -cp . com.hks.MyApp

    }
}
