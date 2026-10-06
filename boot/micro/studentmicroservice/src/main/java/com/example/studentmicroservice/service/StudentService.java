package com.example.studentmicroservice.service;

import com.example.studentmicroservice.model.Student;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private final List<Student> students = new ArrayList<>();

    public StudentService() {

        students.add(
                new Student(
                        1,
                        "Rupesh",
                        "MSc Computer Science",
                        1,
                        "rupesh@gmail.com"
                )
        );

        students.add(
                new Student(
                        2,
                        "Amit",
                        "MCA",
                        2,
                        "amit@gmail.com"
                )
        );
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public Student getStudentById(int id) {

        for (Student student : students) {
            if (student.getStudentId() == id) {
                return student;
            }
        }

        return null;
    }

    public Student addStudent(Student student) {
        students.add(student);
        return student;
    }

    public Student updateStudent(
            int id,
            Student updatedStudent) {

        Student existingStudent = getStudentById(id);

        if (existingStudent != null) {

            existingStudent.setName(
                    updatedStudent.getName()
            );

            existingStudent.setCourse(
                    updatedStudent.getCourse()
            );

            existingStudent.setSemester(
                    updatedStudent.getSemester()
            );

            existingStudent.setEmail(
                    updatedStudent.getEmail()
            );

            return existingStudent;
        }

        return null;
    }

    public boolean deleteStudent(int id) {

        return students.removeIf(
                student ->
                        student.getStudentId() == id
        );
    }
}