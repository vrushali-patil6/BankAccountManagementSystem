public class BankManager {

    private BankAccount account;

    public BankManager(BankAccount account) {
        this.account = account;
    }

    public void depositMoney(double amount) {
        account.deposit(amount);
    }

    public void withdrawMoney(double amount) {

        try {
            account.withdraw(amount);
        }
        catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
    }

    public void showBalance() {

        System.out.println(
                "Current Balance: ₹" +
                        account.getBalance()
        );
    }

    public void showTransactionHistory() {

        if (account.getTransactions().isEmpty()) {

            System.out.println(
                    "No transactions found."
            );
        }
        else {

            System.out.println(
                    "\nTransaction History:"
            );

            for (Transaction transaction :
                    account.getTransactions()) {

                System.out.println(transaction);
            }
        }
    }
}