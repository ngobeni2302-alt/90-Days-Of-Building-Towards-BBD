import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BankTest {

    private Bank bank;

    @BeforeEach
    void setUp() {
        bank = new Bank();
    }

    @Test
    @DisplayName("Bank should add accounts and return an unmodifiable or copied list")
    void testAddAndGetAccounts() {
        BankAccount normalAcc = new BankAccount("REG-001") {};
        SavingsAccount savingsAcc = new SavingsAccount("SAV-001", 0.05);

        bank.addAccount(normalAcc);
        bank.addAccount(savingsAcc);

        List<BankAccount> accounts = bank.getAccounts();
        assertEquals(2, accounts.size());

        // Ensure defensive copying: modifying the returned list shouldn't break internal bank state
        accounts.clear();
        assertEquals(2, bank.getAccounts().size(), "Internal accounts list should be protected via defensive copying");
    }

    @Test
    @DisplayName("totalBalance should correctly sum balances across mixed account types (Polymorphism)")
    void testTotalBalance() {
        BankAccount normalAcc = new BankAccount("REG-001") {};
        normalAcc.deposit(500.0);

        SavingsAccount savingsAcc = new SavingsAccount("SAV-001", 0.05);
        savingsAcc.deposit(1000.0);

        bank.addAccount(normalAcc);
        bank.addAccount(savingsAcc);

        // 500 + 1000 = 1500
        assertEquals(1500.0, bank.getTotalBalance(), 0.001);
    }

    @Test
    @DisplayName("applyInterestToAll should only apply interest to SavingsAccount instances")
    void testApplyInterestToAll() {
        BankAccount normalAcc = new BankAccount("REG-001") {};
        normalAcc.deposit(1000.0); // Should remain untouched by interest

        SavingsAccount savingsAcc = new SavingsAccount("SAV-001", 0.10); // 10% interest
        savingsAcc.deposit(1000.0);

        bank.addAccount(normalAcc);
        bank.addAccount(savingsAcc);

        bank.applyInterestToAll();

        assertEquals(1000.0, normalAcc.getBalance(), 0.001, "Regular accounts should not receive interest");
        assertEquals(1100.0, savingsAcc.getBalance(), 0.001, "Savings accounts should receive interest");
    }

    @Test
    @DisplayName("findAccount should locate the correct account by account number")
    void testFindAccount() {
        BankAccount normalAcc = new BankAccount("REG-001") {};
        SavingsAccount savingsAcc = new SavingsAccount("SAV-001", 0.05);

        bank.addAccount(normalAcc);
        bank.addAccount(savingsAcc);

        BankAccount found = bank.findAccount("SAV-001");
        assertNotNull(found);
        assertEquals("SAV-001", found.getAccountName());

        // Test searching for non-existent account
        BankAccount missing = bank.findAccount("MISSING-999");
        assertNull(missing);
    }
}