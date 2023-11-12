package com.example.student_crud_spring.confing;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;

import java.sql.SQLException;

import javax.sql.DataSource;

@RequiredArgsConstructor
@Configuration
public class JooqConfig {
    private static final Logger logger = LoggerFactory.getLogger(JooqConfig.class);

    @Autowired
    private DataSource dataSource;

    @Bean
    public DSLContext getDSLContext() {
        try {
            return DSL.using(dataSource.getConnection(), SQLDialect.POSTGRES);
        } catch (SQLException e) {
            logger.error("Failed to create DSLContext", e);
            throw new RuntimeException("Failed to create DSLContext", e);
        }
    }
}
