package com.example.student_crud_spring.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class StudentDto {
    @NonNull private Long id;
    private String firstname;
    private String middlename;
    private String lastname;
}
