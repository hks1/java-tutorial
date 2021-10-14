package com.tutorial.java.enums;

public class EnumExample {

    // Before enums, we would use a set of constants (public static final) like below
    /*public static final int HIGH = 1;
    public static final int MEDIUM = 2;
    public static final int LOW = 3;

    public static final String FILE = "FILE";
    public static final String HTTP = "HTTP";*/

    public static void main(String[] args) {
        Level level = Level.HIGH; // using enum, alternative to 'public static final'

        //int levelInt = HIGH; // using public static final declaration above

        if(level == Level.HIGH){

        }else if(level == Level.MEDIUM){

        } else {

        }

        System.out.println("enum with switch()");
        // enum has implicit toString() method
        switch (level){
            case HIGH -> {
                System.out.println(Level.HIGH);
                break;
            }
            case MEDIUM -> {
                System.out.println(Level.MEDIUM);
                break;
            }
            case LOW -> {
                System.out.println(Level.LOW);
                break;
            }
        }

        System.out.println("Level.values()");
        Level[] values = Level.values();
        for (Level aLevel :
                values) {
            System.out.println(aLevel);
        }

        Level high = Level.valueOf("HIGH");
        System.out.println(high);
    }
}
