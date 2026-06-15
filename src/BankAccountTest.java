import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    @Test
    void testDeposit() {

        BankAccount account =
                new BankAccount("101", "Vrushali", 1000);

        account.deposit(500);

        assertEquals(1500, account.getBalance());
    }

    @Test
    void testWithdraw() throws InsufficientFundsException {

        BankAccount account =
                new BankAccount("101", "Vrushali", 1000);

        account.withdraw(300);

        assertEquals(700, account.getBalance());
    }

    @Test
    void testInsufficientFunds() {

        BankAccount account =
                new BankAccount("101", "Vrushali", 1000);

        assertThrows(
                InsufficientFundsException.class,
                () -> account.withdraw(2000)
        );
    }

    @Test
    void testTransactionHistory() {

        BankAccount account =
                new BankAccount("101", "Vrushali", 1000);

        account.deposit(500);

        assertEquals(1, account.getTransactions().size());
    }
}