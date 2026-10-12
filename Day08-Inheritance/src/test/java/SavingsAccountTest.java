import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class SavingsAccountTest {

    @Test
    @DisplayName("SavingsAccount should inherit base properties and start with 0.0 balance")
    void testInheritedInitialBalance() {
        SavingsAccount account = new SavingsAccount("SAV-001", 0.05);
        assertEquals("SAV-001", account.getAccountNumber());
        assertEquals(0.0, account.getBalance(), 0.001);
    }

    @Test
    @DisplayName("applyInterest should correctly calculate and add interest to the balance")
    void testApplyInterest() {
        SavingsAccount account = new SavingsAccount("SAV-001", 0.10); // 10% interest
        account.deposit(1000.0);

        account.applyInterest();

        // 1000 + (1000 * 0.10) = 1100.0
        assertEquals(1100.0, account.getBalance(), 0.001);
    }

    @Test
    @DisplayName("Overridden withdraw should succeed if remaining balance stays at or above R100.0")
    void testValidSavingsWithdrawal() {
        SavingsAccount account = new SavingsAccount("SAV-001", 0.05);
        account.deposit(500.0);

        // Withdraw 300 -> Remaining balance is 200 (>= 100, so it passes)
        account.withdraw(300.0);
        assertEquals(200.0, account.getBalance(), 0.001);
    }

    @Test
    @DisplayName("Overridden withdraw should throw exception and leave balance unchanged if balance drops below R100.0")
    void testMinimumBalanceEnforcement() {
        SavingsAccount account = new SavingsAccount("SAV-001", 0.05);
        account.deposit(500.0);

        // Attempting to withdraw 450 would leave 50, which is below the R100 minimum
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(450.0));

        // Critical: balance must remain completely untouched on failure!
        assertEquals(500.0, account.getBalance(), 0.001);
    }

    @Test
    @DisplayName("Withdrawal should fail if account starts with less than or equal to R100 and tries to withdraw")
    void testWithdrawWhenNearMinimum() {
        SavingsAccount account = new SavingsAccount("SAV-001", 0.05);
        account.deposit(120.0);

        // Withdrawing 30 leaves 90 (below R100 minimum)
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(30.0));
        assertEquals(120.0, account.getBalance(), 0.001);
    }
}