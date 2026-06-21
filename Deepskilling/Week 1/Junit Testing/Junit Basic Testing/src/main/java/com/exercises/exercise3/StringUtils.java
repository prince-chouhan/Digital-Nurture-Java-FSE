package com.exercises.exercise3;

/**
 * Exercise 3: Assertions in JUnit
 *
 * A simple StringUtils class whose methods demonstrate
 * the variety of JUnit assertion types.
 */
public class StringUtils {


    public String toUpperCase(String input) {
        if (input == null) return null;
        return input.toUpperCase();
    }

    public boolean isPalindrome(String input) {
        if (input == null) return false;
        String cleaned = input.toLowerCase();
        String reversed = new StringBuilder(cleaned).reverse().toString();
        return cleaned.equals(reversed);
    }


    public String getNullValue() {
        return null;
    }

    public Object getNonNullValue() {
        return new Object();
    }
}
