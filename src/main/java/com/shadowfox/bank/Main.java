package com.shadowfox.bank;

import com.shadowfox.bank.exception.InsufficientFundsException;
import com.shadowfox.bank.model.BankAccount;
import com.shadowfox.bank.service.BankManager;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BankManager manager = new BankManager();

        int choice;

        do {

            System.out.println("\n========== BANK ACCOUNT MANAGEMENT SYSTEM ==========");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. View Transaction History");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Account Number: ");
                    String accountNumber = sc.nextLine();

                    System.out.print("Enter Account Holder Name: ");
                    String accountHolder = sc.nextLine();

                    System.out.print("Enter Initial Balance: ");
                    double balance = sc.nextDouble();

                    manager.createAccount(
                            new BankAccount(
                                    accountNumber,
                                    accountHolder,
                                    balance
                            )
                    );

                    break;

                case 2:

                    System.out.print("Enter Account Number: ");
                    accountNumber = sc.nextLine();

                    System.out.print("Enter Amount: ");
                    double depositAmount = sc.nextDouble();

                    manager.deposit(accountNumber, depositAmount);

                    break;

                case 3:

                    System.out.print("Enter Account Number: ");
                    accountNumber = sc.nextLine();

                    System.out.print("Enter Amount: ");
                    double withdrawAmount = sc.nextDouble();

                    try {

                        manager.withdraw(
                                accountNumber,
                                withdrawAmount
                        );

                    } catch (InsufficientFundsException e) {

                        System.out.println(e.getMessage());
                    }

                    break;

                case 4:

                    System.out.print("Enter Account Number: ");
                    accountNumber = sc.nextLine();

                    manager.displayAccount(accountNumber);

                    break;

                case 5:

                    System.out.print("Enter Account Number: ");
                    accountNumber = sc.nextLine();

                    manager.displayTransactions(accountNumber);

                    break;

                case 6:

                    System.out.println("Thank you for using Bank Account Management System!");
                    break;

                default:

                    System.out.println("Invalid Choice.");
            }

        } while (choice != 6);

        sc.close();
    }
}