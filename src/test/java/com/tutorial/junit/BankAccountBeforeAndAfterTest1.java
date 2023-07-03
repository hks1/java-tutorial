package com.tutorial.junit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BankAccountBeforeAndAfterTest1 {
    static BankAccount bankAccount;

    @BeforeAll
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
        assertEquals(700, bankAccount.getBalance());
    }

    @AfterAll
    public void endTest(){
        System.out.println("tests completed, use it for resource cleanup!");
    }
}
