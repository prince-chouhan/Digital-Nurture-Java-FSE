package com.exercises.advanced.exercise3;

import java.util.ArrayList;
import java.util.List;

/**
 * Advanced Exercise 3: Test Execution Order
 * TaskManager maintains a list of tasks that are created, updated, and deleted in sequence.
 */
public class TaskManager {

    private final List<String> tasks = new ArrayList<>();

    public void addTask(String task) {
        tasks.add(task);
    }

    public void updateTask(int index, String newTask) {
        tasks.set(index, newTask);
    }

    public void removeTask(String task) {
        tasks.remove(task);
    }

    public List<String> getTasks() {
        return tasks;
    }

    public int getTaskCount() {
        return tasks.size();
    }
}
