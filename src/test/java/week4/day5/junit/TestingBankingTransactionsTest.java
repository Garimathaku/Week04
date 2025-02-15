package week4.day5.junit;


import com.week4.day_5.junit.TestingBankingTransactions;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class TestingBankingTransactionsTest {

    private TestingBankingTransactions account;

    @BeforeEach
    void setUp() {
        account = new TestingBankingTransactions(1000.0);  // Starting balance of 1000
    }

    // Test if deposit correctly updates the balance
    @Test
    void testDeposit() {
        account.deposit(500.0);  // Deposit 500
        assertEquals(1500.0, account.getBalance(), "Balance should be 1500 after deposit.");
    }

    // Test if withdrawal correctly updates the balance
    @Test
    void testWithdraw() {
        boolean success = account.withdraw(200.0);  // Withdraw 200
        assertTrue(success, "Withdrawal should succeed.");
        assertEquals(800.0, account.getBalance(), "Balance should be 800 after withdrawal.");
    }

    // Test withdrawal with insufficient funds
    @Test
    void testWithdrawInsufficientFunds() {
        boolean success = account.withdraw(1500.0);  // Try withdrawing 1500, which exceeds balance
        assertFalse(success, "Withdrawal should fail due to insufficient funds.");
        assertEquals(1000.0, account.getBalance(), "Balance should remain 1000 after failed withdrawal.");
    }

    // Test if balance is correctly initialized
    @Test
    void testInitialBalance() {
        assertEquals(1000.0, account.getBalance(), "Initial balance should be 1000.");
    }

    @AfterEach
    void tearDown() {
        // Clean up resources if necessary
        account = null;
    }
}

