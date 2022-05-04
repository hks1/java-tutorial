package com.ctci;

// 1.5
//

public class OneAway {
    public boolean oneAway(String str1, String str2){
        int l1 = str1.length();
        int l2 = str2.length();
        if(l1 == l2 + 1){ //check if str1 is one insert away from str2
            return oneInsertAway(str1, str2);
        }
        if(l1 + 1 == l2){ // check if str1 is one delete away from str2 OR str2 is one insert away from atr1
            return oneInsertAway(str2, str1);
        }
        if(l1 == l2){
            return oneReplaceAway(str1, str2);
        }
        return false;
    }

    private boolean oneInsertAway(String str1, String str2){
        int ptr1 = 0;
        int ptr2 = 0;
        int numDiffs = 0;
        for(int i = 0; i < str2.length(); i++){
            if(str1.charAt(ptr1) != str2.charAt(ptr2)){
                if(numDiffs == 1){
                    return false;
                }
                numDiffs++;
                ptr1++;
            }
            ptr1++;
            ptr2++;
        }
        return true;
    }

    private boolean oneReplaceAway(String str1, String str2){
        int numDiff = 0;
        for(int i = 0; i < str1.length(); i++){
            if(str1.charAt(i) != str2.charAt(i)){
                if(numDiff == 1){
                    return false;
                }
                numDiff++;
            }
        }
        return true;
    }
}
