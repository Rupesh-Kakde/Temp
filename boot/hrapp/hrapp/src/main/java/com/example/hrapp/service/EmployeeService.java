package com.example.hrapp.service;

import com.example.hrapp.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private final List<Employee> employees = new ArrayList<>();

    public EmployeeService() {
        employees.add(
            new Employee(1, "Rupesh", "IT",
                    "Software Developer", 50000)
        );

        employees.add(
            new Employee(2, "Amit", "HR",
                    "HR Executive", 40000)
        );
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void deleteEmployee(int id) {
        employees.removeIf(employee -> employee.getId() == id);
    }
}