package com.tutorial.junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

@DisplayName("Test BankAccount class")
class BankAccountTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getBalance() {
    }

    @Test
    void getMinimumBalance() {
    }

    @Test
    @DisplayName("withdraw 500 successfully")
    void withdraw() {
        BankAccount bankAccount = new BankAccount(500, -1000);
        bankAccount.withdraw(300);
        assertEquals(200, bankAccount.getBalance());
    }

    @Test
    @DisplayName("Deposit 400 successfully")
    void deposit() {
        BankAccount bankAccount = new BankAccount(400, 0);
        bankAccount.deposit(500);
        assertEquals(900, bankAccount.getBalance());
    }

    @Test
    @DisplayName("balance negative after withdrawl")
    public void testWithdrawNotStuckAtZero(){
        BankAccount bankAccount = new BankAccount(500, -1000);
        bankAccount.withdraw(800);
        assertNotEquals(0, bankAccount.getBalance());
    }

    @Test
    @DisplayName("Test that we can't withdraw below minimum")
    public void testNoWithdrawBelowMinimum(){
        BankAccount bankAccount = new BankAccount(500, -1000);
        assertThrows(RuntimeException.class, () -> bankAccount.withdraw(2000));
    }

    @Test
    @DisplayName("Test no exceptions for withdraw and deposit")
    public void testWithdrawAndDepositWithoutExceptions(){
        BankAccount bankAccount = new BankAccount(500, -1000);
        assertAll(() -> bankAccount.deposit(200), () -> bankAccount.withdraw(450));
    }

    @Test
    public void testDepositTimeout(){
        BankAccount bankAccount = new BankAccount(400, 0);
        assertTimeout(Duration.ofNanos(1), () -> bankAccount.deposit(200));
        //assertEquals(0.33, 1.0/3);
        assertEquals(0.33, 1.0/3, 0.1);

    }

    @Test
    @DisplayName("test for account active assuming that account is not null")
    public void testActive(){
        BankAccount bankAccount = new BankAccount(500, 0);
        assumeTrue(bankAccount != null, "Account is null");
        assertTrue(bankAccount.isActive());
    }
    @Test
    public void testActive1(){
        //BankAccount bankAccount = new BankAccount(500, 0);
        //assertTrue(bankAccount != null, "Account is null");
        BankAccount bankAccount = null;
        //assumeFalse(bankAccount == null, "Account is null");
        assumeTrue(bankAccount != null, "Account is null");

        assertTrue(bankAccount.isActive());
    }

    @Test
    public void testActive2(){
        BankAccount bankAccount = new BankAccount(500, 0);
        assumingThat(bankAccount != null, () -> assumeTrue(bankAccount.isActive()));
    }
}