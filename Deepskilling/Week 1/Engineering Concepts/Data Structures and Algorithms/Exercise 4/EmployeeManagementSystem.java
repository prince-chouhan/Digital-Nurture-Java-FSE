package Cognizant_DN.DeepSkilling.Week1.EngineeringConcepts.DataStructuresAndAlgorithms.Exercise4;

public class EmployeeManagementSystem {

    private Employee[] employees;
    private int size;

    public EmployeeManagementSystem(int capacity) {
        employees = new Employee[capacity];
    }

    public void addEmployee(Employee employee) {
        employees[size++] = employee;
    }

    public Employee searchEmployee(int id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId == id) {
                return employees[i];
            }
        }
        return null;
    }

    public void deleteEmployee(int id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId == id) {
                for (int j = i; j < size - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                size--;
                break;
            }
        }
    }

    public void traverse() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }
}