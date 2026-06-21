package com.exercises.exercise2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLoggingExample {

    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLoggingExample.class);

    public static void main(String[] args) {
        String username = "Alice";
        int userId = 42;
        double accountBalance = 1500.75;

        logger.info("User '{}' has logged in with ID: {}", username, userId);
        logger.debug("Account balance for user '{}' is: {}", username, accountBalance);
        logger.warn("User '{}' has a low balance of: {}", username, accountBalance);

        try {
            processTransaction(userId, -200.00);
        } catch (IllegalArgumentException e) {
            logger.error("Transaction failed for user '{}' with ID {}: {}", username, userId, e.getMessage());
        }
    }

    private static void processTransaction(int userId, double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Transaction amount cannot be negative: " + amount);
        }
        logger.info("Processing transaction of {} for user ID: {}", amount, userId);
    }
}
