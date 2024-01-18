package com.rsp;

import com.rsp.dao.StudentDaoImpl;
import com.rsp.dao.StudentTableBo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootJdbc03Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBootJdbc03Application.class, args);
        StudentDaoImpl dao = context.getBean(StudentDaoImpl.class);
        StudentTableBo st = dao.getStudentById(1);
        System.out.println(st);

//        dao.getAllStudents().forEach(std-> System.out.println(std));
        dao.getAllStudents().forEach(System.out::println);
    }

}
