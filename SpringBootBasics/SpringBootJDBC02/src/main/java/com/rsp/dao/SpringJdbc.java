package com.rsp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SpringJdbc {

    private static final String SQLQ = "INSERT INTO student(id, name, city) values (1, 'RSP', 'MMD')";

    @Autowired //spring will inject required
    private JdbcTemplate jdbc;

    public void insert(){
        jdbc.update(SQLQ);
    }
}
