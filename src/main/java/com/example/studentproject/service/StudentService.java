package com.example.studentproject.service;

import com.example.studentproject.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudent();
    void addStudent(Student student);

    Student getStudentById(Long id);
}
