package com.tutorial.java.synchronization;

public class BankAccount {

    private int balance;
    private final int overdraft;

    public BankAccount(int overdraft) {
        this.overdraft = overdraft;
    }

    void topUp(int amount){
        balance += amount;
    }

    void debit(int amount){
        balance -= amount;
    }

    public int getOverdraft() {
        return overdraft;
    }

    public int getBalance() {
        return balance;
    }
}
