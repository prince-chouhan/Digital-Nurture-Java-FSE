package Cognizant_DN.DeepSkilling.Week1.EngineeringConcepts.DataStructuresAndAlgorithms.Exercise5;

public class TaskManagementSystem {

    class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
        }
    }

    private Node head;

    public void addTask(Task task) {
        Node node = new Node(task);

        if (head == null) {
            head = node;
            return;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = node;
    }

    public Task searchTask(int id) {
        Node current = head;

        while (current != null) {
            if (current.task.taskId == id) {
                return current.task;
            }
            current = current.next;
        }

        return null;
    }

    public void deleteTask(int id) {
        if (head == null) {
            return;
        }

        if (head.task.taskId == id) {
            head = head.next;
            return;
        }

        Node current = head;

        while (current.next != null) {
            if (current.next.task.taskId == id) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    public void traverse() {
        Node current = head;

        while (current != null) {
            System.out.println(current.task.taskName);
            current = current.next;
        }
    }
}