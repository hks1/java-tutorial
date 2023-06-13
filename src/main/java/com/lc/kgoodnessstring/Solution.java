package com.lc.kgoodnessstring;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for(int i = 1; i <= t; i++){
            int n = in.nextInt();
            int k = in.nextInt();
            //System.out.println("Case #" + i + ": " + (n + k) + " " + (n * k));
            String str = in.next();
            System.out.println("Case #" + i + ": " + goodness(str, k));
            //System.out.println("Case #" + i + ": " + (n + k) + " " + (n * k) + " " + str);
        }
    }

    public static int goodness(String str, int k){
        int n = str.length()-1;
        int counter = 0;
        for(int i = 0; i < str.length()/2; i++){
            if(str.charAt(i) != str.charAt(n-i)){
                counter++;
            }
        }
        return (counter > k ? 0 : k - counter);
    }
}

