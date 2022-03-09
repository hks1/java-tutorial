package com.headfirst.java.simpledotcom;

import java.util.Scanner;

public class SimpleDotComGame {
    public static void main(String[] args) {
        SimpleDotCom game = new SimpleDotCom(6);
        Scanner in = new Scanner(System.in);
        //System.out.println();
        boolean winner = false;
        while(!winner){
            System.out.println("take a pick:");
            int guess = in.nextInt();
            if(game.check(guess) == 0) winner = true;
        }
    }
}
