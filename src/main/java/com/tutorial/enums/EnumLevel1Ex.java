package com.tutorial.enums;

import java.util.EnumMap;
import java.util.EnumSet;

public class EnumLevel1Ex {
    public static void main(String[] args) {
        Level1 level1 = Level1.LOW;
        Level1 high = Level1.HIGH;

        System.out.println(level1.getIntValue());

        System.out.println(Level1.HIGH.normalize());
        System.out.println(Level1.MEDIUM.normalize());
        System.out.println(Level1.LOW.normalize());

        EnumSet enumSet = EnumSet.of(Level.HIGH, Level.MEDIUM);

        System.out.println(enumSet);

        EnumMap<Level, String> enumMap = new EnumMap<>(Level.class);
        enumMap.put(Level.HIGH, "High Value");
        enumMap.put(Level.LOW, "Low Value");

        System.out.println(enumMap);
    }
}
