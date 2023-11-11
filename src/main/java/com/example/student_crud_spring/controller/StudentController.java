package com.example.student_crud_spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.student_crud_spring.dto.StudentDto;
import com.example.student_crud_spring.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentDto> doGet() {
        try {
            return studentService.getAllStudents();
        } catch (Exception e) {
            logger.error("Error in GET request", e);
            throw e;
        }
    }

    @GetMapping("/{id}")
    public StudentDto doGet(@PathVariable Long id) {
        try {
            return studentService.getStudent(id);
        } catch (Exception e) {
            logger.error("Error in GET request for student with ID: {}", id, e);
            throw e;
        }
    }

    @PostMapping
    public StudentDto doPost(@RequestBody StudentDto student) {
        try {
            studentService.addStudent(student);
            return student;
        } catch (Exception e) {
            logger.error("Error in POST request", e);
            throw e;
        }
    }

    @PutMapping("/{id}")
    public StudentDto doPut(@PathVariable Long id, @RequestBody StudentDto student) {
        try {
            student.setId(id);
            studentService.updateStudent(student);
            return student;
        } catch (Exception e) {
            logger.error("Error in PUT request for student with ID: {}", id, e);
            throw e;
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> doDelete(@PathVariable Long id) {
        try {
            studentService.deleteStudent(id);
            return new ResponseEntity<>("Student deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error in DELETE request for student with ID: {}", id, e);
            throw e;
        }
    }
}
