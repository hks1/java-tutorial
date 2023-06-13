package com.lc.kgoodnessstring.centaturiprime;

import java.util.*;

public class Solution {

    private static String getRuler(String kingdom) {
        // TODO: implement this method to determine the ruler name, given the kingdom.
        String ruler = "";
        Set<Character> set = new HashSet<>();
        set.addAll(Arrays.asList(new Character[]{'a','e','i','o','u'}));
        char c = kingdom.charAt(kingdom.length()-1);
        if(set.contains(c)){
            ruler = "Alice";
        } else if(c == 'y'){
            ruler = "nobody";
        } else {
            ruler = "Bob";
        }
        return ruler;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int T = in.nextInt();

            for (int t = 1; t <= T; ++t) {
                String kingdom = in.next();
                System.out.println(
                        "Case #" + t + ": " + kingdom + " is ruled by " + getRuler(kingdom) + ".");
            }
        }
    }
}

