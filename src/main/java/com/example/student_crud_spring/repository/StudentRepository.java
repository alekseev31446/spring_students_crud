package com.example.student_crud_spring.repository;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.student_crud_spring.dto.StudentDto;

import static org.jooq.impl.DSL.table;
import static org.jooq.impl.DSL.field;


import java.util.List;
import java.util.Optional;


@Repository
public class StudentRepository {

    private final DSLContext dslContext;

    @Autowired
    public StudentRepository(DSLContext dslContext) {
        this.dslContext = dslContext;
    }
    
    public List<StudentDto> getAll() {
        return dslContext.select().from(table("students")).fetchInto(StudentDto.class);
    }
    
    public Optional<StudentDto> getById(Long id) {
        return Optional.ofNullable(
            dslContext
                .select()
                .from(table("students"))
                .where(field("id").eq(id))
                .fetchOneInto(StudentDto.class)
        );
    }
    
    public void create(StudentDto studentDto) {
        dslContext
            .insertInto(table("students"))
            .set(field("firstname"), studentDto.getFirstname())
            .set(field("middlename"), studentDto.getMiddlename())
            .set(field("lastname"), studentDto.getLastname())
            .execute();
    }
    
    public void update(StudentDto studentDto) {
        dslContext
            .update(table("students"))
            .set(field("firstname"), studentDto.getFirstname())
            .set(field("middlename"), studentDto.getMiddlename())
            .set(field("lastname"), studentDto.getLastname())
            .where(field("id").eq(studentDto.getId()))
            .execute();
    }
    
    public void delete(Long id) {
        dslContext
            .deleteFrom(table("students"))
            .where(field("id").eq(id))
            .execute();
    }
    
}

