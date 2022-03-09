package com.tutorial.collections.collection.map.properties;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Properties;

public class PropertiesExample2 {
    public static void main(String[] args) {
        // Store properties to XML file
        Properties properties = new Properties();

        properties.put("key1", "value1");
        properties.put("key2", "value2");
        properties.put("key3", "value3");

        try(FileOutputStream output = new FileOutputStream("props.xml")){
            properties.storeToXML(output, "These are properties", Charset.forName("ISO-8859-1")); // default UTF-8
        } catch (IOException e){
            e.printStackTrace();
        }


    }
}
