package com.tutorial.collections.collection.map.properties;

import java.util.Properties;

public class PropertiesExample6 {
    public static void main(String[] args) {
        // Properties is a Subclass of Hashtable - by Mistake!
            // The Java Properties class is a subclass of the Java Hashtable class,
                // and as I will show you - this is actually a design mistake!
                // It is a great example of when the classic "Is a / Has a" OOP rule about
                // when to use inheritance vs. composition fails.

        //Being a subclass of Hashtable,
        // you can actually use the get() and put() method of the Hashtable class,
        // which allow the use of non-string keys and values.
        // This defeats the purpose of the Properties class, which is to function as a string,string map.
        // Here is an example of using put() on Properties:
        Properties asProperties = new Properties();

        asProperties.put(123, 456);
        asProperties.put("abc", 999);

        String abc = asProperties.getProperty("abc");
        System.out.println(abc); // The getProperty("abc") call will actually return null !!

        // If instead the value passed to put() had been two strings, then it would have worked as expected.
        asProperties.put("abc", "999");

        abc = asProperties.getProperty("abc");
        System.out.println(abc);
    }
}
