package org.rsp.controller;

import jakarta.servlet.http.HttpSession;

import org.rsp.model.User;
import org.rsp.model.UserPrincipal;
import org.rsp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

//    @GetMapping("/register")
//    public String showRegistrationForm(Model model){
//        model.addAttribute("user", new User());
//        return "registration";
//    }
//
//    @PostMapping("/register")
//    public String registerUser(@ModelAttribute("user") User user){
//        userService.registerUser(user);
//        return "home";
//    }

    @GetMapping("/login")
    public String showLoginForm(){
        return "login";
    }

//    @PostMapping("/login")
//    public String loginUser(User user, Model model){
//        Optional<User> userEmail = userService.getUserByEmail(user.getEmail());
//        if (userEmail.isPresent() && userEmail.get().getPassword().equals(user.getPassword())){
//            return "redirect:/dashboard";
//        }else {
//            model.addAttribute("error", "Invalid details");
//            return "login";
//        }
//    }

    @GetMapping("/")
    public String showDashboard(HttpSession session, Model model){
        System.out.println("into dashboard method...");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal principal = (UserPrincipal) auth.getPrincipal();
        User user = principal.getUser();
        System.out.println(user);

        if (user.getRole().toString().equalsIgnoreCase("USER")){
            session.setAttribute("user", user);
            model.addAttribute("user", user);
            return "dashboard";
        } else if (user.getRole().toString().equalsIgnoreCase("ADMIN")) {
            session.setAttribute("user", user);
            model.addAttribute("user", user);
            return "admin-dashboard";
        }
        System.out.println("out of dashboard");
        return "login";
    }
}
