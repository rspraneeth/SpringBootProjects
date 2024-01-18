package com.rsp.dao;

import java.util.List;

public interface IStudentDao {
    public StudentTableBo getStudentById(int id);
    public List<StudentTableBo> getAllStudents();
}
