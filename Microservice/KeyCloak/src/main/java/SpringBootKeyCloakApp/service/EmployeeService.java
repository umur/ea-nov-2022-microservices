package SpringBootKeyCloakApp.service;

import SpringBootKeyCloakApp.entity.Employee;
import SpringBootKeyCloakApp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;


    public Employee getEmployee(int empId){
        return employeeRepository.findById(empId).orElse(null);
    }
    public List<Employee> getAllEmployees(){
        return (List<Employee>) employeeRepository.findAll();
    }

    public Employee addEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
}
