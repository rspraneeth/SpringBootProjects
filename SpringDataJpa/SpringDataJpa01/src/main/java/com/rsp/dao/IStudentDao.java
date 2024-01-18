package com.rsp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;


@Repository
public interface IStudentDao extends CrudRepository<Student, Serializable> {
}
