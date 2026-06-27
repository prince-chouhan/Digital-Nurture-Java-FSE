package com.princechouhan.employeemanagementsystem.dto;

public record EmployeeRequest(String name, String email, Double salary, Boolean permanent, Long departmentId) {
}
