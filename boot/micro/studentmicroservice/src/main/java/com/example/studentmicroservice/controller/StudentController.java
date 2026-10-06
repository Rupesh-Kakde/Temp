package com.example.studentmicroservice.controller;

import com.example.studentmicroservice.model.Student;
import com.example.studentmicroservice.service.StudentService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(
            StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {

        return ResponseEntity.ok(
                studentService.getAllStudents()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(
            @PathVariable int id) {

        Student student =
                studentService.getStudentById(id);

        if (student != null) {
            return ResponseEntity.ok(student);
        }

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Student not found");
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(
            @RequestBody Student student) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        studentService.addStudent(student)
                );
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(
            @PathVariable int id,
            @RequestBody Student student) {

        Student updatedStudent =
                studentService.updateStudent(
                        id,
                        student
                );

        if (updatedStudent != null) {
            return ResponseEntity.ok(updatedStudent);
        }

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Student not found");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(
            @PathVariable int id) {

        boolean deleted =
                studentService.deleteStudent(id);

        if (deleted) {
            return ResponseEntity.ok(
                    "Student deleted successfully"
            );
        }

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Student not found");
    }
}