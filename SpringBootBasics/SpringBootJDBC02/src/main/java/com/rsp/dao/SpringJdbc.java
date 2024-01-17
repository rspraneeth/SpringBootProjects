package com.rsp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SpringJdbc {



    @Autowired //spring will inject required
    private JdbcTemplate jdbc;

//    private static final String SQLQ = "INSERT INTO student(id, name, city) values (1, 'RSP', 'MMD')";

//    public void insert(){
//        System.out.println("Implementing class of JDBCTemplate: "+jdbc.getClass().getName());
//        jdbc.update(SQLQ);
//    }

    private static final String SQLQ = "INSERT INTO course(cid, cname) values (?, ?)";

    public void insert(CourseInfo cinfo){
        System.out.println("Implementing class of JDBCTemplate: "+jdbc.getClass().getName());
        jdbc.update(SQLQ, cinfo.getCid(), cinfo.getCname());
    }

    public void deleteById(long cid){
        jdbc.update("DELETE FROM course where cid=?", cid);
    }


    public CourseInfo findById(Integer cid){
        return jdbc.queryForObject("select cid, cname from course where cid=?", new BeanPropertyRowMapper<>(CourseInfo.class), cid);
    }


}
