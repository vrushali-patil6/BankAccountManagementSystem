package com.shadowfox.bank.test;

import com.shadowfox.bank.exception.InsufficientFundsException;
import com.shadowfox.bank.model.BankAccount;
import com.shadowfox.bank.service.BankManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankManagerTest {

    @Test
    void testCreateAccount() {

        BankManager manager = new BankManager();

        BankAccount account = new BankAccount(
                "1001",
                "Vrushali Patil",
                5000
        );

        manager.createAccount(account);

        assertNotNull(manager.searchAccount("1001"));
    }

    @Test
    void testDeposit() {

        BankManager manager = new BankManager();

        BankAccount account = new BankAccount(
                "1002",
                "Rahul Sharma",
                3000
        );

        manager.createAccount(account);

        manager.deposit("1002", 2000);

        assertEquals(
                5000,
                manager.searchAccount("1002").getBalance(),
                0.001
        );
    }

    @Test
    void testWithdraw() throws InsufficientFundsException {

        BankManager manager = new BankManager();

        BankAccount account = new BankAccount(
                "1003",
                "Anjali Patil",
                8000
        );

        manager.createAccount(account);

        manager.withdraw("1003", 3000);

        assertEquals(
                5000,
                manager.searchAccount("1003").getBalance(),
                0.001
        );
    }

    @Test
    void testInsufficientFunds() {

        BankManager manager = new BankManager();

        BankAccount account = new BankAccount(
                "1004",
                "Rohan",
                1000
        );

        manager.createAccount(account);

        assertThrows(
                InsufficientFundsException.class,
                () -> manager.withdraw("1004", 5000)
        );
    }
}