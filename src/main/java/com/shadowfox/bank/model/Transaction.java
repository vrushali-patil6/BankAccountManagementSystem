package com.shadowfox.bank.model;

import java.time.LocalDateTime;

public class Transaction {

    private String transactionType;
    private double amount;
    private LocalDateTime transactionDate;

    public Transaction(String transactionType, double amount) {

        this.transactionType = transactionType;
        this.amount = amount;
        this.transactionDate = LocalDateTime.now();
    }

    public String getTransactionType() {
        return transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    @Override
    public String toString() {

        return transactionType +
                " | ₹" + amount +
                " | " + transactionDate;
    }
}