import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    @Test
    @DisplayName("New bank account should start with a balance of 0.0")
    void testInitialBalance() {
        BankAccount account = new BankAccount("ACC-123");
        assertEquals(0.0, account.getBalance(), 0.001);
    }

    @Test
    @DisplayName("Depositing a valid positive amount should increase the balance")
    void testValidDeposit() {
        BankAccount account = new BankAccount("ACC-123");
        account.deposit(100.0);
        assertEquals(100.0, account.getBalance(), 0.001);

        account.deposit(50.5);
        assertEquals(150.5, account.getBalance(), 0.001);
    }

    @Test
    @DisplayName("Depositing zero or negative amounts should throw IllegalArgumentException")
    void testInvalidDeposit() {
        BankAccount account = new BankAccount("ACC-123");
        assertThrows(IllegalArgumentException.class, () -> account.deposit(0.0));
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-50.0));
    }

    @Test
    @DisplayName("Withdrawing a valid amount should decrease the balance")
    void testValidWithdrawal() {
        BankAccount account = new BankAccount("ACC-123");
        account.deposit(200.0);
        account.withdraw(75.0);
        assertEquals(125.0, account.getBalance(), 0.001);
    }

    @Test
    @DisplayName("Withdrawing zero or negative amounts should throw IllegalArgumentException")
    void testInvalidWithdrawalAmount() {
        BankAccount account = new BankAccount("ACC-123");
        account.deposit(100.0);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(0.0));
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-20.0));
    }

    @Test
    @DisplayName("Withdrawing more than the current balance should throw exception and leave balance unchanged")
    void testInsufficientFunds() {
        BankAccount account = new BankAccount("ACC-123");
        account.deposit(100.0);

        assertThrows(IllegalArgumentException.class, () -> account.withdraw(150.0));

        // Critical: balance must remain completely untouched on failure!
        assertEquals(100.0, account.getBalance(), 0.001);
    }
}