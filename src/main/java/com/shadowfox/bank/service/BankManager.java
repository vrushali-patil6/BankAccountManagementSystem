package com.shadowfox.bank.service;

import com.shadowfox.bank.exception.InsufficientFundsException;
import com.shadowfox.bank.model.BankAccount;
import com.shadowfox.bank.model.Transaction;

import java.util.ArrayList;

public class BankManager {

    private ArrayList<BankAccount> accounts;

    public BankManager() {
        accounts = new ArrayList<>();
    }

    // Create Account
    public void createAccount(BankAccount account) {

        if (searchAccount(account.getAccountNumber()) != null) {

            System.out.println("Account already exists!");
            return;
        }

        accounts.add(account);

        System.out.println("Account created successfully.");
    }

    // Search Account
    public BankAccount searchAccount(String accountNumber) {

        for (BankAccount account : accounts) {

            if (account.getAccountNumber().equals(accountNumber)) {

                return account;
            }
        }

        return null;
    }

    // Deposit Money
    public void deposit(String accountNumber, double amount) {

        if (amount <= 0) {

            System.out.println("Deposit amount must be greater than zero.");
            return;
        }

        BankAccount account = searchAccount(accountNumber);

        if (account != null) {

            account.deposit(amount);

            System.out.println("Amount deposited successfully.");
        }
        else {

            System.out.println("Account not found.");
        }
    }

    // Withdraw Money
    public void withdraw(String accountNumber, double amount)
            throws InsufficientFundsException {

        if (amount <= 0) {

            System.out.println("Withdrawal amount must be greater than zero.");
            return;
        }

        BankAccount account = searchAccount(accountNumber);

        if (account == null) {

            System.out.println("Account not found.");
            return;
        }

        if (amount > account.getBalance()) {

            throw new InsufficientFundsException(
                    "Insufficient Balance!"
            );
        }

        account.withdraw(amount);

        System.out.println("Amount withdrawn successfully.");
    }

    // Display Account Details
    public void displayAccount(String accountNumber) {

        BankAccount account = searchAccount(accountNumber);

        if (account != null) {

            System.out.println("\n----- ACCOUNT DETAILS -----");
            System.out.println(account);
        }
        else {

            System.out.println("Account not found.");
        }
    }

    // Display Transaction History
    public void displayTransactions(String accountNumber) {

        BankAccount account = searchAccount(accountNumber);

        if (account != null) {

            System.out.println("\n----- TRANSACTION HISTORY -----");

            if (account.getTransactions().isEmpty()) {

                System.out.println("No transactions available.");
            }
            else {

                for (Transaction transaction : account.getTransactions()) {

                    System.out.println(transaction);
                }
            }
        }
        else {

            System.out.println("Account not found.");
        }
    }
}