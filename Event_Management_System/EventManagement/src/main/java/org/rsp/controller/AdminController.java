package org.rsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("")
    public String adminLoginForm(){
        return "admin";
    }

    @PostMapping("")
    public String adminLoginForm(@RequestParam String uname, @RequestParam String pass){
        if (uname.equals("admin") && pass.equals("admin")){
            return "admin-dashboard";
        }
        return "admin";
    }

    @GetMapping("/dashboard")
    public String adminDashboard(){
        return "admin-dashboard";
    }


}
