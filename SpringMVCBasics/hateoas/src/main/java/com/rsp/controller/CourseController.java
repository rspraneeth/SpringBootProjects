package com.rsp.controller;

import com.rsp.pojo.Course;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    List<Course> courses = new ArrayList<>();

    @GetMapping("/add")
    public ResponseEntity<? extends Course> getCourseInfo(){
        Course course = new Course(1, "Java", 22.99);
        courses.add(course);
        Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CourseController.class).getAllCourses()).withRel("allCoursesLink");
        course.add(link);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<Course> getAllCourses(){
        Course course = new Course(3, "Microservices", 20.99);
        Course course1 = new Course(2, "Spring", 24.99);
        courses.add(course);
        courses.add(course1);
        return courses;
    }
}
