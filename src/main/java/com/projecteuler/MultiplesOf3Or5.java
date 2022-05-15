package com.projecteuler;

public class MultiplesOf3Or5 {
    //Multiples of 3 or 5
    //Problem 1
    //If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
    //
    //Find the sum of all the multiples of 3 or 5 below 1000.
    public int sumOfMultiplesOf3Or5(int n){
        int sum = 0;
        for(int i = 1; i < n; i++){
            if(i % 3 == 0 || i % 5 == 0){
                sum += i;
            }
        }
        return sum;
    }
}

class TDMultiplesOf3Or5{
    public static void main(String[] args) {
        MultiplesOf3Or5 obj = new MultiplesOf3Or5();
        System.out.println(obj.sumOfMultiplesOf3Or5(1000));
    }
}
