package com.rsp;

import com.rsp.dao.CourseInfo;
import com.rsp.dao.SpringJdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StudentCommandLineRunner implements CommandLineRunner {

    @Autowired
    private SpringJdbc springJdbc;

    @Override
    public void run(String... args) throws Exception {
        springJdbc.insert(new CourseInfo(1, "Java"));
        springJdbc.insert(new CourseInfo(2, "C#"));
        springJdbc.insert(new CourseInfo(3, "SpringBoot"));

        springJdbc.deleteById(2);
        System.out.println(springJdbc.findById(1));
    }
}
