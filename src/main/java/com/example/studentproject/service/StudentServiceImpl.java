package com.example.studentproject.service;

import com.example.studentproject.model.Student;
import com.example.studentproject.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        log.info("get student by id: {}", id);
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            return optionalStudent.get();
        } else {
            throw new RuntimeException("Student not found.");
        }
    }
}
