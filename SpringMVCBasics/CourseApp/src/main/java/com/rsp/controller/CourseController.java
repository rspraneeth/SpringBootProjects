package com.rsp.controller;

import com.rsp.pojo.Course;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CourseController {

    @GetMapping("/coursedetails")
    public String getCourseDetails(Model model){
        model.addAttribute("cid", "1");
        model.addAttribute("cname", "SpringBoot");
        model.addAttribute("cprice", "2999 inr");

        return "course";
    }

    @GetMapping("/courseinfo")
    public String getCourseInfo(Model model){
        Course course = new Course(1, "SpringBoot Course", 3999.99, "3 months");
        model.addAttribute("course", course);
        return "courseInfo";
    }

    @GetMapping({"/courseinformation", "/coursedet", "/course"}) //multiple bindings
    public String getCourseInformation(Model model){
        Course course = new Course(1, "SpringBoot Course", 3999.99, "3 months");
        model.addAttribute("course", course);
        return "courseInfo";
    }

    @GetMapping("/courses")
    public String getCourses(Model model){
        String[] books = {"Java", "Spring", "MicroServices", "JPA"};
        model.addAttribute("books", books);

        Course c1 = new Course(1, "SpringBoot Course", 3999.99, "3 months");
        Course c2 = new Course(2, "Java Course", 2999.99, "2 months");
        Course c3 = new Course(2, "Jpa Course", 1999.99, "1 months");
        Course[] cs = {c1, c2, c3};
        model.addAttribute("cs", cs);
        return "courses";
    }
}
