package com.exercises.advanced.exercise5;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Advanced Exercise 5: Timeout and Performance Testing
 * PerformanceTesterTest ensures methods complete within acceptable time limits.
 */
public class PerformanceTesterTest {

    private final PerformanceTester tester = new PerformanceTester();

    @Test
    void testPerformTaskCompletesWithinOneSecond() {
        assertTimeout(Duration.ofSeconds(1), () -> tester.performTask());
    }

    @Test
    void testPerformTaskReturnsExpectedResult() {
        assertTimeout(Duration.ofSeconds(1), () -> {
            String result = tester.performTask();
            assertEquals("Task completed", result);
        });
    }

    @Test
    void testPerformTaskPreemptiveTimeout() {
        assertTimeoutPreemptively(Duration.ofMillis(500), () -> tester.performTask());
    }

    @Test
    void testSlowTaskExceedsShortTimeout() {
        assertThrows(
                AssertionError.class,
                () -> assertTimeoutPreemptively(
                        Duration.ofMillis(500),
                        () -> tester.performSlowTask()
                )
        );
    }

    @Test
    void testSumComputationIsInstant() {
        assertTimeout(Duration.ofMillis(100), () -> {
            int result = tester.sumUpTo(1_000_000);
            assertEquals(500000500000L, (long) result, 1);
        });
    }
}
