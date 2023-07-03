package com.tutorial.junit;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountDisabledTest {
    @Test
    //@Disabled
    @Disabled("Temporarily disabled due to maintainance")
    @DisplayName("Deposit 400 successfully")
    void deposit(BankAccount bankAccount) {
        bankAccount.deposit(500);
        assertEquals(500, bankAccount.getBalance());
    }
}
