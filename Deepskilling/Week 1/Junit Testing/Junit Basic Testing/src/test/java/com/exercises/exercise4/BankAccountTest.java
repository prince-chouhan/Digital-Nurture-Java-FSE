package com.exercises.exercise4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Exercise 4: Arrange-Act-Assert (AAA) Pattern, Test Fixtures,
 *             Setup and Teardown Methods in JUnit
 */
public class BankAccountTest {


    private BankAccount account;

    @Before
    public void setUp() {
        account = new BankAccount("Rishabh", 1000.00);
        System.out.println("[setUp] New BankAccount created for Alice with balance $1000.00");
    }

    @After
    public void tearDown() {
        account = null;
        System.out.println("[tearDown] BankAccount reference released.");
    }

    @Test
    public void testInitialBalance() {

        double balance = account.getBalance();
        assertEquals("Initial balance should be 1000.00", 1000.00, balance, 0.001);
    }

    @Test
    public void testDepositIncreasesBalance() {
        double depositAmount = 500.00;
        account.deposit(depositAmount);
        assertEquals("Balance after deposit should be 1500.00",
                     1500.00, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdrawDecreasesBalance() {

        double withdrawAmount = 200.00;
        account.withdraw(withdrawAmount);
        assertEquals("Balance after withdrawal should be 800.00",
                     800.00, account.getBalance(), 0.001);
    }

    @Test
    public void testMultipleDepositsAndWithdrawals() {
        double firstDeposit  = 300.00;
        double secondDeposit = 200.00;
        double withdrawal    = 400.00;

        account.deposit(firstDeposit);
        account.deposit(secondDeposit);
        account.withdraw(withdrawal);

        assertEquals("Net balance should be 1100.00",
                     1100.00, account.getBalance(), 0.001);
    }

    @Test(expected = IllegalStateException.class)
    public void testWithdrawMoreThanBalanceThrowsException() {

        double overdraftAmount = 5000.00;
        account.withdraw(overdraftAmount);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testDepositNegativeAmountThrowsException() {
        double negativeDeposit = -100.00;

        account.deposit(negativeDeposit);
    }

    @Test
    public void testAccountOwner() {

        String owner = account.getOwner();
        assertEquals("Owner name should be Rishabh", "Rishabh", owner);
        assertNotNull("Owner should not be null", owner);
    }
}
