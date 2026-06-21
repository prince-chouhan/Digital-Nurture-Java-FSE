package com.exercises.advanced.exercise5;

/**
 * Advanced Exercise 5: Timeout and Performance Testing
 * PerformanceTester contains tasks of varying durations to demonstrate JUnit timeout assertions.
 */
public class PerformanceTester {

    public String performTask() throws InterruptedException {
        Thread.sleep(100);
        return "Task completed";
    }

    public String performSlowTask() throws InterruptedException {
        Thread.sleep(3000);
        return "Slow task completed";
    }

    public int sumUpTo(int n) {
        int total = 0;
        for (int i = 1; i <= n; i++) {
            total += i;
        }
        return total;
    }
}
