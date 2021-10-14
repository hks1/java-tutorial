package com;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Sum{
    public void printSquare(double x){
        System.out.println(x*x);
    }

    public static void main(String[] args) {
        Sum sum = new Sum();
        sum.printSquare(5);
        //sum.printSquare("Hello");
        String s;
        Process p;
        try {
            p = Runtime.getRuntime().exec("cmd /c dir");
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(p.getInputStream())
            );
            while ((s = br.readLine()) != null){
                System.out.println("line : " + s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}