package com.tutorial.synchronization;

public class ATM {

    // synchronized - only one thread can enter the method at a time
    static synchronized void withdraw(BankAccount account, int amount){
        int balance = account.getBalance();
        if((balance - amount) < - account.getOverdraft()){
            System.out.println("Transaction denied!");
        } else {
            account.debit(amount);
            System.out.println("$" + amount + " successfully withdrawn");
        }
        System.out.println("Current balance: " + account.getBalance());
    }
}
