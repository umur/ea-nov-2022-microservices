package com.example.springbootkeycloakexample.controller;

import com.example.springbootkeycloakexample.entity.Employee;
import com.example.springbootkeycloakexample.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {
    public final EmployeeService employeeService;

    //can be accssed by user whose role is user
    @RolesAllowed("admin")
    @GetMapping
    public ResponseEntity<List<Employee>> getEmployee()
    {
        return  ResponseEntity.ok(employeeService.getAllEmployees());
    }

    //this method can be accessed by user whose role is admin
    @GetMapping("/{employeeId}")
    @RolesAllowed("user")
    public ResponseEntity<Employee> getEmployee(@PathVariable int employeeId)
    {
        return  ResponseEntity.ok(employeeService.getEmployee(employeeId));
    }

}
