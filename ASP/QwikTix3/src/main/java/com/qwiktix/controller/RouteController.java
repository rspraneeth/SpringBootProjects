package com.qwiktix.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qwiktix.data.BaseUserPrincipal;
import com.qwiktix.data.User;
import com.qwiktix.facades.IAuthenticationFacade;
import com.qwiktix.request.RegistrationRequest;
import com.qwiktix.service.EventService;
import com.qwiktix.service.ReservationService;
import com.qwiktix.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RouteController {

    @Autowired
    private IAuthenticationFacade authenticationFacade;
    @Autowired
    private EventService eventService;
    @Autowired
    private ReservationService reservationService;
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String admin_dashboard(Model model, HttpSession session) {
        try {
            Authentication authentication = authenticationFacade.getAuthentication();
            BaseUserPrincipal baseUserPrincipal = (BaseUserPrincipal) authentication.getPrincipal();
            User user = baseUserPrincipal.getUser();
            if (user.getRole().toString().equalsIgnoreCase("ADMIN")) {
                session.setAttribute("user", user);
                model.addAttribute("user", user);
                model.addAttribute("adminEventResponse",eventService.adminEvent());
                model.addAttribute("adminReservationResponse",reservationService.adminReservations());
                model.addAttribute("adminUserResponse",userService.getUserResponse());
                return "admin_dashboard";
            }else if(user.getRole().toString().equalsIgnoreCase("USER")) {
                session.setAttribute("user", user);
                model.addAttribute("user", user);
                System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(reservationService.getUserReservations(user.getId())));
                model.addAttribute("userReservationsResponse",reservationService.getUserReservations(user.getId()));
                return "user_dashboard";
            }
            return "login";
        }catch (Exception e){
            return "login";
        }
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("registrationRequest", new RegistrationRequest());
        return "register";
    }

    @GetMapping("/admin/events/add")
    public String admin_add_event(Model model) {
        return "admin_add_event";
    }

    @GetMapping("/admin/events")
    public String admin_events(Model model) {
        model.addAttribute("adminEventResponse",eventService.adminEvent());
        return "admin_all_events";
    }


    @RequestMapping("/contact")
    public String contact() {
        return "contact";
    }

    @RequestMapping("/about")
    public String about() {
        return "about";
    }
}
