package com.lc.problems;

import java.util.*;

public class SlidingWindowProblems {
    // 643. Maximum Average Subarray I
    //You are given an integer array nums consisting of n elements, and an integer k.
    //
    //Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.
    public double findMaxAverage(int[] nums, int k) {
        //int maxWindowSum = 0;
        int windowSum = 0;
        for(int i = 0; i < k ; i++){
            windowSum += nums[i];
        }
        int maxWindowSum = windowSum;
        for(int i = k; i < nums.length; i++){
            windowSum -= nums[i-k];
            windowSum += nums[i];
            maxWindowSum = Math.max(maxWindowSum, windowSum);
        }
        return maxWindowSum * 1.0 / k;
    }
    // 1343. Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold
    //Given an array of integers arr and two integers k and threshold, return the number of sub-arrays of size k and average greater than or equal to threshold.
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0;
        int windowSum = 0;
        for(int i = 0; i < k; i++){
            windowSum += arr[i];
        }
        int avg = windowSum/k;
        count += (avg >= threshold ? 1 : 0);
        for(int i = k; i < arr.length; i++){
            windowSum -= arr[i-k];
            windowSum += arr[i];
            avg = windowSum/k;
            count += (avg >= threshold ? 1 : 0);
        }
        return count;
    }
    // 1176. Diet Plan Performance
    //A dieter consumes calories[i] calories on the i-th day.
    //
    //Given an integer k, for every consecutive sequence of k days (calories[i], calories[i+1], ..., calories[i+k-1] for all 0 <= i <= n-k), they look at T, the total calories consumed during that sequence of k days (calories[i] + calories[i+1] + ... + calories[i+k-1]):
    //
    //If T < lower, they performed poorly on their diet and lose 1 point;
    //If T > upper, they performed well on their diet and gain 1 point;
    //Otherwise, they performed normally and there is no change in points.
    //Initially, the dieter has zero points. Return the total number of points the dieter has after dieting for calories.length days.
    //
    //Note that the total points can be negative.
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int points = 0;
        int T = 0;
        for(int i = 0; i < k; i++){
            T += calories[i];
        }
        points += (T > upper ? 1 : T < lower ? -1 : 0);
        for (int i = k; i < calories.length; i++){
            T -= calories[i-k];
            T += calories[i];
            if(T > upper) points++;
            if(T < lower) points--;
        }
        return points;
    }

    //1052. Grumpy Bookstore Owner
    //There is a bookstore owner that has a store open for n minutes. Every minute, some number of customers enter the store. You are given an integer array customers of length n where customers[i] is the number of the customer that enters the store at the start of the ith minute and all those customers leave after the end of that minute.
    //
    //On some minutes, the bookstore owner is grumpy. You are given a binary array grumpy where grumpy[i] is 1 if the bookstore owner is grumpy during the ith minute, and is 0 otherwise.
    //
    //When the bookstore owner is grumpy, the customers of that minute are not satisfied, otherwise, they are satisfied.
    //
    //The bookstore owner knows a secret technique to keep themselves not grumpy for minutes consecutive minutes, but can only use it once.
    //
    //Return the maximum number of customers that can be satisfied throughout the day.
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int window = 0; // customers grumpy in a minutes minutes window
        int maxWindow = 0; // max grumpy customers in a minutes window
        int happyCustomers = 0; // keep accumulating happy customers during the pass
        for(int i = 0; i < minutes; i++){
            window += customers[i] * grumpy[i];
            happyCustomers += customers[i] * (grumpy[i] ^ 1);
        }
        maxWindow = window;
        for(int i = minutes; i < customers.length; i++){
            window -= customers[i-minutes] * grumpy[i-minutes];
            window += customers[i] * grumpy[i];
            maxWindow = Math.max(maxWindow, window);
            happyCustomers += customers[i] * (grumpy[i] ^ 1);
        }
        return happyCustomers + maxWindow;
    }

    // 1456. Maximum Number of Vowels in a Substring of Given Length
    //Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
    //
    //Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
    public int maxVowels(String s, int k) {
        Set<Character> vowelSet = new HashSet<>();
        vowelSet.addAll(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int count = 0;
        int maxVowels = 0;
        for(int i = 0; i < k; i++){
            if(vowelSet.contains(s.charAt(i)) ) count++;
        }
        maxVowels = count;
        for(int i = k ; i < s.length(); i++){
            if(vowelSet.contains(s.charAt(i-k))) count--;
            if(vowelSet.contains(s.charAt(i))) count++;
            maxVowels = Math.max(maxVowels, count);
        }
        return maxVowels;
    }

    // 1100. Find K-Length Substrings With No Repeated Characters
    //Given a string s and an integer k, return the number of substrings in s of length k with no repeated characters.
    public int numKLenSubstrNoRepeats(String s, int k) {
        if(k > s.length()) return 0;
        int count = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < k; i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        count += (map.size() == k ? 1 : 0);
        for(int i = k; i < s.length(); i++){
            if(map.get(s.charAt(i-k)) == 1){
                map.remove(s.charAt(i-k));
            }else{
                map.put(s.charAt(i-k), map.get(s.charAt(i-k)) - 1);
            }
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            if(map.size() == k) count++;
        }
        return count;
    }

    // 239. Sliding Window Maximum
    //You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
    //
    //Return the max sliding window.
    public int[] maxSlidingWindow(int[] nums, int k) {
        return new int[]{0};
    }
}

// 346. Moving Average from Data Stream
//Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
//
//Implement the MovingAverage class:
//
//MovingAverage(int size) Initializes the object with the size of the window size.
//double next(int val) Returns the moving average of the last size values of the stream.
class MovingAverage {
    Queue<Integer> q;
    int size;
    int sum;

    public MovingAverage(int size) {
        q = new LinkedList<>();
        this.size = size;
        sum = 0;
    }

    public double next(int val) {
        if(q.size() < this.size){
            q.offer(val);
        }else{
            sum -= q.poll();
            q.offer(val);
        }
        sum += val;
        return sum*1.0/q.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */