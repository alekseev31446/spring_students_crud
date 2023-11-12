package com.example.student_crud_spring.service;

import org.springframework.stereotype.Service;

import com.example.student_crud_spring.dto.StudentDto;
import com.example.student_crud_spring.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public List<StudentDto> getAll() {
        return studentRepository.getAll();
    }
    
    public StudentDto getById(Integer id) {
    	return studentRepository.getById(id).orElse(null);
    }
    
    public StudentDto create(StudentDto student) {
        return studentRepository.create(student);
    }
    
    public StudentDto update(StudentDto student) {
    	return studentRepository.update(student);
    }
    
    public void delete(Integer id) {
    	studentRepository.delete(id);
    }
}
