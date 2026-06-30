import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Account Number: ");
        String accountNumber = sc.nextLine();

        System.out.print("Enter Account Holder Name: ");
        String accountHolderName = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double initialBalance = sc.nextDouble();

        BankAccount account =
                new BankAccount(
                        accountNumber,
                        accountHolderName,
                        initialBalance
                );

        BankManager manager =
                new BankManager(account);

        int choice;

        do {

            System.out.println(
                    "\n===== BANK ACCOUNT MANAGEMENT SYSTEM ====="
            );

            System.out.println(
                    "1. Deposit Money"
            );

            System.out.println(
                    "2. Withdraw Money"
            );

            System.out.println(
                    "3. Check Balance"
            );

            System.out.println(
                    "4. Transaction History"
            );

            System.out.println(
                    "5. Exit"
            );

            System.out.print(
                    "Enter your choice: "
            );

            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print(
                            "Enter amount to deposit: ₹"
                    );

                    double depositAmount =
                            sc.nextDouble();

                    manager.depositMoney(
                            depositAmount
                    );

                    break;

                case 2:

                    System.out.print(
                            "Enter amount to withdraw: ₹"
                    );

                    double withdrawAmount =
                            sc.nextDouble();

                    manager.withdrawMoney(
                            withdrawAmount
                    );

                    break;

                case 3:

                    manager.showBalance();

                    break;

                case 4:

                    manager.showTransactionHistory();

                    break;

                case 5:

                    System.out.println(
                            "Thank you for using the Bank Account Management System!"
                    );

                    break;

                default:

                    System.out.println(
                            "Invalid choice."
                    );
            }

        } while (choice != 5);

        sc.close();
    }
}