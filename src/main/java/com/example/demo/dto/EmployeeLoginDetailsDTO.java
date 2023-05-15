package com.example.demo.dto;

public record EmployeeLoginDetailsDTO(long id, EmployeeDTO employee, String userName, String password) {
}
