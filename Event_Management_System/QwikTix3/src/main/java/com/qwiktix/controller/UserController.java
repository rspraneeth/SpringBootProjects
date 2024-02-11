package com.qwiktix.controller;

import com.qwiktix.data.User;
import com.qwiktix.enums.Role;
import com.qwiktix.helpers.ValidationHelper;
import com.qwiktix.request.RegistrationRequest;
import com.qwiktix.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ValidationHelper validationHelper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("registrationRequest") RegistrationRequest registrationRequest, RedirectAttributes redirectAttributes) {
        User user = new User(
                registrationRequest.getName(),
                registrationRequest.getEmail(),
                registrationRequest.getEmail(),
                passwordEncoder.encode(registrationRequest.getPassword()),
                registrationRequest.getDob(),
                Role.USER
        );
        if (!validationHelper.isValidRegistrationData(user)){
            redirectAttributes.addFlashAttribute("errorMessage", "Data is Invalid, enter valid data");
            return "redirect:/register";
        }
        try {
            String result = userService.registerNewUser(user);
            if (result.equalsIgnoreCase("success")) {
                redirectAttributes.addFlashAttribute("successMessage", "Account Created Successfully!Login to proceed");
                return "redirect:/login";
            } else {
                redirectAttributes.addFlashAttribute("errorMessage", "Failed to register.Please try again");
                return "redirect:/register";
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Failed to register.Please try again");
            return "redirect:/register";
        }
    }

}
