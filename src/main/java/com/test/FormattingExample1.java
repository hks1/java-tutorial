package com.test;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Example1 {
    public static void main(String[] args) {
        int x = 100;

        // System.out.printf
        System.out.printf("printing simple integer x = %d\n", x);
        System.out.format("printing simple integer x = %d\n", x).println();
        System.out.printf("formatted with precision: PI = %.2f\n", Math.PI);
        float n = 5.3f;
        System.out.printf("formatted to specific width: n = %.4f\n", n);
        n = 2324435.3f;
        System.out.printf("formatted to right margin: n = %20.4f\n", n);

        // DecimalFormat class
        double num = 123.4567;

        // prints only numeric part of the floating number
        DecimalFormat ft = new DecimalFormat("####");
        System.out.println("without fraction part: num = " + ft.format(num));
        // print upto to 2 decimal places
        ft = new DecimalFormat("#.##");
        System.out.println("formatted to give precision: num =  " + ft.format(num));
        // automatically appends zero to the rightmost part
        // of decimal instead of #,we use digit 0
        ft = new DecimalFormat("#.000000");
        System.out.println("appends zeros to the right: num = " + ft.format(num));

        // automatically appends zero to the leftmost of
        // decimal number instead of #,we use digit 0
        ft = new DecimalFormat("00000.00");
        System.out.println("formatting numeric part : num +  " + ft.format(num));

        // formatting money in dollars
        double income = 23456.789;
        ft = new DecimalFormat("$###,###.##");
        System.out.println("formatted income: " + ft.format(income));

        // formatting dates and parsing using SimpleDateFormat class

        // formatting as per given pattern in the argument
        SimpleDateFormat dtft = new SimpleDateFormat("dd-MM-yyyy");
        String str = dtft.format(new Date());
        System.out.println("formatted date : " + str);

        // parsing a given string
        str = "02/18/1995";
        dtft = new SimpleDateFormat("MM/dd/yyyy");
        try{
            Date dt = dtft.parse(str);
            System.out.println("parsed date : " + dt);
        }catch (ParseException e){
            System.err.println("exception in parsing date : " + e);
        }

    }
}
