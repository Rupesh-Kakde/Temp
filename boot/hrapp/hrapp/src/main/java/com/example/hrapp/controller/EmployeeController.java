package com.example.hrapp.controller;

import com.example.hrapp.model.Employee;
import com.example.hrapp.service.EmployeeService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/employees";
    }

    @GetMapping("/employees")
    public String getEmployees(Model model) {

        model.addAttribute(
                "employees",
                employeeService.getAllEmployees()
        );

        return "employees";
    }

    @GetMapping("/employees/new")
    public String showEmployeeForm(Model model) {

        model.addAttribute("employee", new Employee());

        return "employee-form";
    }

    @PostMapping("/employees/save")
    public String saveEmployee(
            @ModelAttribute("employee") Employee employee) {

        employeeService.addEmployee(employee);

        return "redirect:/employees";
    }

    @GetMapping("/employees/delete/{id}")
    public String deleteEmployee(@PathVariable int id) {

        employeeService.deleteEmployee(id);

        return "redirect:/employees";
    }
}