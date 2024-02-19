package com.rsp.controller;

import com.rsp.pojo.Course;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    @GetMapping(value = "/courseInfo", produces = {"application/xml", "application/json"})
    public Course getCourse(){
        Course course = new Course(1, "Spring", 223.34);
        System.out.println(course);
        return course;
    }


}
