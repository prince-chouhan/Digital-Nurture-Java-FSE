package com.exercises.advanced.exercise3;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Advanced Exercise 3: Test Execution Order
 * OrderedTests controls the sequence of test methods using @TestMethodOrder and @Order.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OrderedTests {

    private final TaskManager manager = new TaskManager();

    @Test
    @Order(1)
    void testAddTask() {
        manager.addTask("Write report");
        manager.addTask("Review code");
        assertEquals(2, manager.getTaskCount());
        assertTrue(manager.getTasks().contains("Write report"));
    }

    @Test
    @Order(2)
    void testUpdateTask() {
        manager.updateTask(0, "Write final report");
        assertTrue(manager.getTasks().contains("Write final report"));
        assertFalse(manager.getTasks().contains("Write report"));
    }

    @Test
    @Order(3)
    void testRemoveTask() {
        manager.removeTask("Review code");
        assertEquals(1, manager.getTaskCount());
        assertFalse(manager.getTasks().contains("Review code"));
    }

    @Test
    @Order(4)
    void testAllTasksCleared() {
        manager.removeTask("Write final report");
        assertEquals(0, manager.getTaskCount());
        assertTrue(manager.getTasks().isEmpty());
    }
}
