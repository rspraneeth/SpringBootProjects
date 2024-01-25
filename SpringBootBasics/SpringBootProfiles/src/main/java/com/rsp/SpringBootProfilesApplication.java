package com.rsp;

import com.rsp.service.Courses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class SpringBootProfilesApplication implements CommandLineRunner {

    @Value("${myproject.name}")
    private String projectName;

    @Autowired
    private Courses course;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootProfilesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Run method "+projectName);
        boolean status = course.registerToCourse(999.0);
        System.out.println(status?"Registered":"Failed");
    }
}
