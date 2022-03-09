package com.headfirst.java.simpledotcom;

import java.security.InvalidParameterException;
import java.util.Arrays;

public class SimpleDotCom {
    int[] locationCells;
    int numOfHits;
    private final int NUMBER_OF_TARGETS = 3;
    int targetsToBeHit;
    int totalAttempts = 0;
    public SimpleDotCom(int length){
        if(length < 0 || length > 20){
            throw new InvalidParameterException("length should be between 0 and 20");
        }
        locationCells = new int[length];
        setUp();

    }

    private void setUp(){
        int startPosition = (int) (Math.random()*(locationCells.length - NUMBER_OF_TARGETS));
        //System.out.println(startPosition);
        for(int i = 0; i < NUMBER_OF_TARGETS; i++){
            locationCells[startPosition + i] = 1;
        }
        targetsToBeHit = NUMBER_OF_TARGETS;
        //System.out.println(Arrays.toString(locationCells));
    }

    public int check(int guess){
        if(guess <= 0 || guess > locationCells.length){
            System.out.println("wrong value, try again");
            return targetsToBeHit;
        }
        totalAttempts++;
        if(locationCells[guess-1] == 1){
            locationCells[guess-1] = 0;
            targetsToBeHit--;
            System.out.println("hit");
            numOfHits++;


        } else{
            System.out.println("miss");
        }
        if(targetsToBeHit == 0){
            System.out.println("you took total " + totalAttempts + " attempts.");
        }
        return targetsToBeHit;
    }

}
