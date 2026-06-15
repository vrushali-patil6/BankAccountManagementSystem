import java.util.ArrayList;

public class BankAccount {

    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private ArrayList<Transaction> transactions;

    public BankAccount(String accountNumber,
                       String accountHolderName,
                       double balance) {

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

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public synchronized void deposit(double amount) {

        if (amount > 0) {
            balance += amount;
            transactions.add(new Transaction("Deposit", amount));
            System.out.println("Deposit Successful!");
        }
        else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public synchronized void withdraw(double amount)
            throws InsufficientFundsException {

        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        }
        else if (amount > balance) {
            throw new InsufficientFundsException(
                    "Insufficient Balance."
            );
        }
        else {
            balance -= amount;
            transactions.add(
                    new Transaction("Withdrawal", amount)
            );

            System.out.println("Withdrawal Successful!");
        }
    }
}