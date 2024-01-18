package com.rsp;

import com.rsp.dao.IStudentDao;
import com.rsp.dao.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringDataJpa01Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringDataJpa01Application.class, args);

        IStudentDao dao = context.getBean(IStudentDao.class);
//        dao.save(new Student(4, "USA", "RSP"));

        System.out.println(dao.findById(4));

        context.close();
    }

}
