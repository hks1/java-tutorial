package com.tutorial.collections.collection.map.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesExample4 {
    public static void main(String[] args) {
        // Load properties from classpath
        Class aClass = PropertiesExample3.class;
        //System.out.println(PropertiesExample3.class.getName());
        InputStream inputStream = aClass.getResourceAsStream("/propertiesFromClass.properties");

        Properties fromClasspath = new Properties();

        System.out.println(System.getProperty("user.dir"));

        try {
            fromClasspath.load(inputStream);
        } catch (IOException e){
            e.printStackTrace();
        }

        System.out.println(fromClasspath);

        // ResourceBundle Properties
        // Internationalization
    }
}
