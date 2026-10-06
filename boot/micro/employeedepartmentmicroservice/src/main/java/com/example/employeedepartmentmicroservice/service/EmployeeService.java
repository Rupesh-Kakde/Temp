package com.example.employeedepartmentmicroservice.service;

import com.example.employeedepartmentmicroservice.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private final List<Employee> employees = new ArrayList<>();

    public EmployeeService() {

        employees.add(
                new Employee(101, "Rupesh",
                        "Software Developer",
                        "IT", 50000)
        );

        employees.add(
                new Employee(102, "Amit",
                        "Tester",
                        "IT", 45000)
        );

        employees.add(
                new Employee(103, "Priya",
                        "HR Executive",
                        "HR", 40000)
        );

        employees.add(
                new Employee(104, "Neha",
                        "Manager",
                        "Finance", 60000)
        );
    }

    public List<Employee> getEmployeesByDepartment(
            String department) {

        List<Employee> result = new ArrayList<>();

        for (Employee employee : employees) {

            if (employee.getDeptName()
                    .equalsIgnoreCase(department)) {

                result.add(employee);
            }
        }

        return result;
    }
}