package com.tutorial.enums;

public class Main {

    public static void main(String[] args) {
        EnumImplementingInterface enumImplementingInterface = EnumImplementingInterface.FIRST;
        String desc = enumImplementingInterface.getDescription();
        System.out.println(desc);
    }



}
