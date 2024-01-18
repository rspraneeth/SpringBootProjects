package com.rsp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("dao1")
public class StudentDaoImpl implements IStudentDao{

    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public StudentTableBo getStudentById(int id) {

        return jdbc.queryForObject("select * from student where id=?", (rs, rowNum) -> {
            StudentTableBo st = new StudentTableBo();
            st.setId(rs.getInt(1));
            st.setCity(rs.getString(2));
            st.setName(rs.getString(3));
            return st;
        }, id);
    }

    @Override
    public List<StudentTableBo> getAllStudents() {
        return jdbc.query("select * from student", (rs, n)-> {
            StudentTableBo st = new StudentTableBo();
            st.setId(rs.getInt(1));
            st.setCity(rs.getString(2));
            st.setName(rs.getString(3));
            return st;

        });
    }
}
