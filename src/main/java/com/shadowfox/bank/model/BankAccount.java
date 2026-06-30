package com.shadowfox.bank.model;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {

    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private List<Transaction> transactions;

    public BankAccount(String accountNumber, String accountHolderName, double balance) {

        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void deposit(double amount) {

        balance += amount;

        transactions.add(
                new Transaction(
                        "Deposit",
                        amount
                )
        );
    }

    public void withdraw(double amount) {

        balance -= amount;

        transactions.add(
                new Transaction(
                        "Withdraw",
                        amount
                )
        );
    }

    @Override
    public String toString() {

        return "\nAccount Number : " + accountNumber +
                "\nAccount Holder : " + accountHolderName +
                "\nBalance        : ₹" + balance;
    }
}