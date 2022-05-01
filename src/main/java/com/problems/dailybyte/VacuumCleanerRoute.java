package com.problems.dailybyte;

// Given a string representing the sequence of moves a robot vacuum makes, return whether or not it will return to its original position. The string will only contain L, R, U, and D characters, representing left, right, up, and down respectively.
//
//Ex: Given the following strings...
//
//"LR", return true
//"URURD", return false
//"RUULLDRD", return true

public class VacuumCleanerRoute {
    public boolean returnToOrigPos(String route){
        int l = 0, r = 0, u = 0, d = 0;
        for(int i = 0; i < route.length(); i++){
            char c = route.charAt(i);
            if(c == 'L'){
                l++;
                r--;
            }
            if(c == 'R'){
                r++;
                l--;
            }
            if(c == 'U'){
                u++;
                d--;
            }
            if(c == 'D'){
                u--;
                d++;
            }
        }
        return l == 0 && r == 0 && u == 0 && d == 0;
    }
}
