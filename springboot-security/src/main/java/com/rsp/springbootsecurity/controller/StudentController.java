package com.rsp.springbootsecurity.controller;

import com.rsp.springbootsecurity.model.Student;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    private List<Student> students = new ArrayList<>();

    public StudentController() {
        Student student1 = new Student(1, "Praneeth", "Reddi");
        Student student2 = new Student(2, "Satya", "Reddi");

        students.add(student1);
        students.add(student2);
    }

    @GetMapping("/students")
    public List<Student> students(){
        return students;
    }

    @PreAuthorize("hasRole('ADMIN')") //only admin can now access post method of students
    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student){
        students.add(student);
        return student;
    }
}
