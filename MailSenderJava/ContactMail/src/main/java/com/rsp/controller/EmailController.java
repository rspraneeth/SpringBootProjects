package com.rsp.controller;

import com.rsp.request.NewContactMailRequest;
import com.rsp.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EmailController {

    @Autowired
    private EmailService emailService;

    @Value("${spring.mail.username}")
    private String companyEmail;

    @GetMapping("/contact")
    public String showContactForm(Model model) {
        model.addAttribute("newContactMailRequest", new NewContactMailRequest());
        return "contactForm";
    }

    @PostMapping("/contact/send/mail/user")
    public String sendContactMailUser(@ModelAttribute NewContactMailRequest newContactMailRequest, Model model) {
        try {
            System.out.println(newContactMailRequest.toString() + " " + companyEmail);
            emailService.sendEmail(companyEmail, newContactMailRequest.getSubject(), newContactMailRequest.getMessage());
            model.addAttribute("message", "Mail sent successfully");
        } catch (Exception e) {
            model.addAttribute("error", "Failed to send email");
        }
        return "result";
    }
}
