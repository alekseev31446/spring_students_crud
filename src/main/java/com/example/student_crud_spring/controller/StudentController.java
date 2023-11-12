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

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/show/all")
    public List<StudentDto> getAll() {
            return studentService.getAll();
        
    }

    @GetMapping("/find/{id}")
    public StudentDto getById(@PathVariable Integer id) {
            return studentService.getById(id);
    }

    @PostMapping("/add")
    public StudentDto create(@RequestBody StudentDto student) {
            return studentService.create(student);
    }

    @PutMapping("/update/{id}")
    public StudentDto update(@PathVariable Integer id, @RequestBody StudentDto student) {
            student.setId(id);
            return studentService.update(student);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
            studentService.delete(id);
            return new ResponseEntity<>("Student deleted successfully", HttpStatus.OK);
    }
}
