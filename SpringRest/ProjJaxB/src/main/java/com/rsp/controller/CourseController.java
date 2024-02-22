package com.rsp.controller;

import com.rsp.pojo.Course;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    @GetMapping(value = "/course/get", produces = {"application/xml", "application/json"})
    public Course getCourse(){
        Course course = new Course();
        course.setId(1);
        course.setName("Java");
        course.setPrice(22.34);
        return course;
    }
}
