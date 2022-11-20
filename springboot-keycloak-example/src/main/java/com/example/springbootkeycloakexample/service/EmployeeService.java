package com.example.springbootkeycloakexample.service;

import com.example.springbootkeycloakexample.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee getEmployee(int employeeId);
    public List<Employee> getAllEmployees();

}
