package com.tutorial.def;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Example3 {
    public static void main(String[] args) {
        int i =0;
        String str = "name it once";
        str = new String("Changed");
        str += " hello!";
        System.out.println(str);
        System.out.println(str.length()  + " " + str.substring(0, 5) + " " + str.indexOf("hello"));
        String theString = "is this good or this is bad";
        String subString = "is";
        int index = theString.indexOf(subString);
        while (index != -1){
            System.out.println(theString + ", " + index + ", " + subString);
            index = theString.indexOf(subString, index + 1);
        }
        System.out.println("lastIndexOf() " + " " + subString + " " +theString.lastIndexOf(subString));

        String one = "abc";
        String two = "def";
        String three = "abd";
        System.out.println(one.compareTo(two));
        System.out.println(one.compareTo(three));
        System.out.println(two.compareTo(three));

        String str1 = "This is a byte test for getByte() method.";
        byte[] bytes1 = str1.getBytes();
        byte[] bytes2 = str1.getBytes(StandardCharsets.UTF_8);
        //byte[] bytes3 = str1.getBytes(Charset.forName("UTF-16"));
        byte[] bytes3 = str1.getBytes(Charset.forName("UTF-16"));
        System.out.println(bytes3.length + ", " + str1.length());
        /*for (byte b:
        bytes3){
            System.out.println(b);
        }*/

        String input = "Hey, \\n This is not normally a line break.";
        System.out.println(input);
        //String output = input.translateEscapes();
        //System.out.println(output);
    }
}
