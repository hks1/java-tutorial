package com.tutorial.collections.collection.map.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesExample3 {
    public static void main(String[] args) {
        // Load properties from XML file
        Properties properties = new Properties();

        try(FileInputStream inputStream = new FileInputStream("props.xml")){
            properties.loadFromXML(inputStream);
        } catch(IOException e){
            e.printStackTrace();
        }

        System.out.println(properties);


    }
}
