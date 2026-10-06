package com.example.employeedepartmentmicroservice.controller;

import com.example.employeedepartmentmicroservice.model.Employee;
import com.example.employeedepartmentmicroservice.service.EmployeeService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(
            EmployeeService employeeService) {

        this.employeeService = employeeService;
    }

    @GetMapping("/department/{department}")
    public ResponseEntity<List<Employee>> getEmployeesByDepartment(
            @PathVariable String department) {

        return ResponseEntity.ok(
                employeeService
                        .getEmployeesByDepartment(department)
        );
    }
}