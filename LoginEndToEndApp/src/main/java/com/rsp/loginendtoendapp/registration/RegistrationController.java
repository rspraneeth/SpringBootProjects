package com.rsp.loginendtoendapp.registration;

import com.rsp.loginendtoendapp.event.RegistrationCompleteEvent;
import com.rsp.loginendtoendapp.user.IUserService;
import com.rsp.loginendtoendapp.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/registration")
public class RegistrationController {
    private final IUserService iUserService;
    private final ApplicationEventPublisher publisher;

    @GetMapping("/registration-form")
    public String showRegistrationForm(Model model){
        model.addAttribute("user", new RegistrationRequest());
        return "registration";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") RegistrationRequest registration){
        User user = iUserService.registerUser(registration);
        //publish the verification email event here
        publisher.publishEvent(new RegistrationCompleteEvent(user, ""));
        return "redirect:/registration/registration-form?success";

    }
}
