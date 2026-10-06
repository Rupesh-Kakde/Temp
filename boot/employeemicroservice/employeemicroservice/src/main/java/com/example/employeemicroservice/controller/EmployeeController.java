package com.example.employeemicroservice.controller;

import com.example.employeemicroservice.model.Employee;
import com.example.employeemicroservice.service.EmployeeService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<String> addEmployee(
            @RequestBody Employee employee) {

        String message =
                employeeService.saveEmployee(employee);

        return ResponseEntity.ok(message);
    }

    @GetMapping
    public ResponseEntity<List<String>> getEmployees() {

        return ResponseEntity.ok(
                employeeService.getEmployees()
        );
    }
}