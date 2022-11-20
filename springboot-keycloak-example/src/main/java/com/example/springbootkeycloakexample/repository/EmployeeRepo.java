package com.example.springbootkeycloakexample.repository;

import com.example.springbootkeycloakexample.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeRepo extends CrudRepository<Employee,Integer> {

}
