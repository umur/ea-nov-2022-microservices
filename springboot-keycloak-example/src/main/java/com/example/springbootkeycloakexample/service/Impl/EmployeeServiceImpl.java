package com.example.springbootkeycloakexample.service.Impl;

import com.example.springbootkeycloakexample.entity.Employee;
import com.example.springbootkeycloakexample.repository.EmployeeRepo;
import com.example.springbootkeycloakexample.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    public final EmployeeRepo employeeRepo;

    @Override
    public Employee getEmployee(int employeeId) {
        return employeeRepo.findById(employeeId).get();
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
         employeeRepo.findAll().forEach(employees::add);
         return employees;
    }
}
