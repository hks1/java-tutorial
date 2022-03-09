package com.tutorial.lambda;

import java.io.FileOutputStream;
import java.io.IOException;

public class LambdaExample3 {
    public static void main(String[] args) throws IOException {

        // Java lambda expression can implement interfaces with
        // a single unimplemented (abstract) method,
        // but as many default or static methods as you like.
        // Such an interface is also called a FUNCTIONAL INTERFACE.

        MyInterface myInterface = (String text) -> {
            System.out.println(text);
        };

        myInterface.printIt("Hello World!!");
        myInterface.printUTF8To("Hello File", new FileOutputStream("data.txt"));
        MyInterface.printItToSystemOut("Print to system out");

    }
}
