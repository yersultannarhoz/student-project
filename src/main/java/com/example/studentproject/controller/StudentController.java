package com.example.studentproject.controller;

import com.example.studentproject.dto.StudentDto;
import com.example.studentproject.model.Student;
import com.example.studentproject.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@Slf4j
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudent();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PostMapping
    public void addStudent(@RequestBody StudentDto dto) {
        log.info("Firstname: {}, LastName: {}", dto.getFirstName(), dto.getLastName());
        Student student = new Student();
        student.setFirstName(dto.getFirstName());
        student.setLastName(dto.getLastName());
        studentService.addStudent(student);
    }
}
