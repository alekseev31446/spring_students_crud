package com.example.student_crud_spring.repository;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.student_crud_spring.confing.JooqConfig;
import com.example.student_crud_spring.dto.StudentDto;

import lombok.RequiredArgsConstructor;

import static org.jooq.impl.DSL.table;
import static org.jooq.impl.DSL.field;


import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class StudentRepository {

    private final DSLContext dslContext;
    private static final Logger logger = LoggerFactory.getLogger(JooqConfig.class);
    
    public List<StudentDto> getAll() {
        return dslContext.select().from(table("students")).fetchInto(StudentDto.class);
    }
    
    public Optional<StudentDto> getById(Integer id) {
        return Optional.ofNullable(
            dslContext
                .select()
                .from(table("students"))
                .where(field("id").eq(id))
                .fetchOneInto(StudentDto.class)
        );
    }
    
    public StudentDto create(StudentDto studentDto) {
        dslContext
                .insertInto(table("students"))
                .set(field("firstname"), studentDto.getFirstname())
                .set(field("middlename"), studentDto.getMiddlename())
                .set(field("lastname"), studentDto.getLastname())
                .execute();

        return dslContext
                .selectFrom(table("students"))
                .where(field("id").eq(dslContext.lastID()))
                .fetchOneInto(StudentDto.class);

    }
    
    public StudentDto update(StudentDto studentDto) {
        dslContext
                .update(table("students"))
                .set(field("firstname"), studentDto.getFirstname())
                .set(field("middlename"), studentDto.getMiddlename())
                .set(field("lastname"), studentDto.getLastname())
                .where(field("id").eq(studentDto.getId()))
                .execute();

        return dslContext
                .selectFrom(table("students"))
                .where(field("id").eq(studentDto.getId()))
                .fetchOneInto(StudentDto.class);
    }


    
    public void delete(Integer id) {
        dslContext
            .deleteFrom(table("students"))
            .where(field("id").eq(id))
            .execute();
    }
    
}

