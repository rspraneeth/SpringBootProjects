package org.rsp.controller;

import org.rsp.model.User;
import org.rsp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user){
        userService.registerUser(user);
        return "home";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model){
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(User user, Model model){
        Optional<User> userEmail = userService.getUserByEmail(user.getEmail());
        if (userEmail.isPresent() && userEmail.get().getPassword().equals(user.getPassword())){
            return "redirect:/dashboard";
        }else {
            model.addAttribute("error", "Invalid details");
            return "login";
        }
    }

    @GetMapping("/dashboard")
    public String showDashboard(){
        return "userDashboard";
    }
}
