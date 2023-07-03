package com.tutorial.junit;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankAccountBeforeAndAfterTest2 {
    static BankAccount bankAccount;

    @BeforeEach
    public void prepTest(){
        System.out.println("starting tests!");
        bankAccount = new BankAccount(500, 0);
    }

    @Test
    public void testWithdraw(){
        bankAccount.withdraw(300);
        assertEquals(200, bankAccount.getBalance());
    }
    @Test
    public void testDeposit(){
        bankAccount.deposit(500);
        assertEquals(1000, bankAccount.getBalance());
    }

    @AfterEach
    public void endTest(){
        System.out.println("tests completed, use it for resource cleanup!");
    }
}
