package com.tutorial.scanner.example;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFile {

    public List<String> read(String fileLocation){
        for(int i = 'a'; i <= 'z'; i++){
            System.out.print((char)i + " :: " + (i - 'a' + 1) + ";; ");
        }
        System.out.println("Printing states: " + fileLocation);
        List<String> states = new ArrayList<>();
        File f = new File(fileLocation);
        try{
            Scanner s = new Scanner(f);
            while (s.hasNextLine()){
                String state = s.nextLine();
                int sum = 0;
                for(int i = 0; i < state.length(); i++){
                    if(Character.isAlphabetic(state.charAt(i))){
                        sum += Character.toLowerCase(state.charAt(i)) - 'a' + 1;
                    }
                }
                System.out.println(state + " " + sum);
                if(sum == 71){
                    System.out.println(state + " " + sum);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return states;
    }
}
