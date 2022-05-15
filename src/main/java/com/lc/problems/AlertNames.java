package com.lc.problems;

import java.util.*;

public class AlertNames {
    //1604. Alert Using Same Key-Card Three or More Times in a One Hour Period
    //LeetCode company workers use key-cards to unlock office doors. Each time a worker uses their key-card, the security system saves the worker's name and the time when it was used. The system emits an alert if any worker uses the key-card three or more times in a one-hour period.
    //
    //You are given a list of strings keyName and keyTime where [keyName[i], keyTime[i]] corresponds to a person's name and the time when their key-card was used in a single day.
    //
    //Access times are given in the 24-hour time format "HH:MM", such as "23:51" and "09:49".
    //
    //Return a list of unique worker names who received an alert for frequent keycard use. Sort the names in ascending order alphabetically.
    //
    //Notice that "10:00" - "11:00" is considered to be within a one-hour period, while "22:51" - "23:52" is not considered to be within a one-hour period.
    public List<String> alertNames(String[] keyName, String[] keyTime){
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < keyName.length; i++){
            String employee = keyName[i];
            if(map.containsKey(employee)){
                map.get(employee).add(keyTime[i]);
            }else{
                map.put(employee, new ArrayList<String>());
                map.get(employee).add(keyTime[i]);
            }
        }
        return null;
    }
}

class TDAlertNames{
    public static void main(String[] args) {
        String[] times = {"10:00","10:40","11:00","09:00","11:00","13:00","15:00"};
        System.out.println(Arrays.toString(times));
        Arrays.sort(times, (t1, t2) ->{
            String[] time1 = t1.split(":");
            String[] time2 = t2.split(":");
            int hh1 = Integer.valueOf(time1[0]);
            int hh2 = Integer.valueOf(time2[0]);
            int mm1 = Integer.valueOf(time1[1]);
            int mm2 = Integer.valueOf(time2[1]);
            //System.out.println("hh1:mm1::hh2:mm2" + hh1 + " " + mm1 + " " + hh2 + " " + mm2);
            if(hh1 != hh2){
                return hh1 - hh2;
            }else{
                return mm1 - mm2;
            }
        });
        //Arrays.sort(times, Comparator.naturalOrder());
        System.out.println(Arrays.toString(times));
        Arrays.sort(times, Comparator.naturalOrder());
        System.out.println(Arrays.toString(times));
    }
}
