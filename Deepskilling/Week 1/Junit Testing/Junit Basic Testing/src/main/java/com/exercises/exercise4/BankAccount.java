package com.exercises.exercise4;

/**
 * Exercise 4: AAA Pattern, Test Fixtures, Setup and Teardown
 *
 * BankAccount models a simple bank account with deposit,
 * withdraw, and balance-query operations.
 */
public class BankAccount {

    private final String owner;
    private double balance;

    public BankAccount(String owner, double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative.");
        }
        this.owner   = owner;
        this.balance = initialBalance;
    }

    /** Deposits the given amount into the account. */
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        balance += amount;
    }

    /**
     * Withdraws the given amount from the account.
     *
     * @throws IllegalArgumentException if amount <= 0
     * @throws IllegalStateException    if insufficient funds
     */
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }
        if (amount > balance) {
            throw new IllegalStateException("Insufficient funds.");
        }
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public String getOwner() {
        return owner;
    }
}
