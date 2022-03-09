package com.tutorial.collections.comparable;

public class ComparableExample1 {
    public static void main(String[] args) {
        Integer valA = new Integer(455);
        Integer valB = Integer.valueOf(577);
        Integer valC = Integer.valueOf(455);

        int comparisionA = valA.compareTo(valB);
        int comparisionB = valB.compareTo(valA);

        System.out.println("comparisionA : " + comparisionA);
        System.out.println("comparisionB : " + comparisionB);


    }
}
