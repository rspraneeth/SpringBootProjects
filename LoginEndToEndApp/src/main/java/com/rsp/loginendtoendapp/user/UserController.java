package com.rsp.loginendtoendapp.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final IUserService iUserService;

    @GetMapping
    public String getUsers(Model model){
        model.addAttribute("users", iUserService.getAllUsers());
        return "users";
    }
}
