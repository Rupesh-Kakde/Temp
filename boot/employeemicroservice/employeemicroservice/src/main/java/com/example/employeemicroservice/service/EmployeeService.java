package com.example.employeemicroservice.service;

import com.example.employeemicroservice.model.Employee;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

@Service
public class EmployeeService {

    private final Path filePath = Path.of("employees.txt");

    public String saveEmployee(Employee employee) {

        String employeeData =
                employee.getEno() + "," +
                employee.getEname() + "," +
                employee.getDesignation() + "," +
                employee.getDeptName() + "," +
                employee.getSalary();

        try {

            Files.writeString(
                    filePath,
                    employeeData + System.lineSeparator(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );

            return "Employee details stored successfully";

        } catch (IOException e) {

            return "Error while storing employee details";
        }
    }

    public List<String> getEmployees() {

        try {

            if (!Files.exists(filePath)) {
                return List.of();
            }

            return Files.readAllLines(filePath);

        } catch (IOException e) {

            return List.of("Error while reading file");
        }
    }
}