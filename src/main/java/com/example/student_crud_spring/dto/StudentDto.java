package com.example.student_crud_spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    private Integer id;
    private String firstname;
    private String middlename;
    private String lastname;
}
