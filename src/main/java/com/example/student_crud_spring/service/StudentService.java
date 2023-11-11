package com.example.student_crud_spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.student_crud_spring.dto.StudentDto;
import com.example.student_crud_spring.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentDto> getAllStudents() {
        return studentRepository.getAll();
    }
    
    public StudentDto getStudent(Long id) {
    	return studentRepository.getById(id).orElse(null);
    }
    
    public void addStudent(StudentDto student) {
        studentRepository.create(student);
    }
    
    public void updateStudent(StudentDto student) {
        studentRepository.update(student);
    }
    
    public void deleteStudent(Long id) {
    	studentRepository.delete(id);
    }
}
