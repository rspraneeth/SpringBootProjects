package com.qwiktix.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qwiktix.data.Event;
import com.qwiktix.data.Reservation;
import com.qwiktix.data.User;
import com.qwiktix.helpers.ValidationHelper;
import com.qwiktix.repository.EventRepository;
import com.qwiktix.repository.UserRepository;
import com.qwiktix.request.NewReservationRequest;
import com.qwiktix.service.ReservationService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ReservationController {
    @Autowired
    private ReservationService reservationService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private ValidationHelper validationHelper;

    @GetMapping("/admin/reservations/add")
    public String admin_add_reservation(Model model) {
        model.addAttribute("users",userRepository.findAll());
        model.addAttribute("events",eventRepository.findAll());
        return "admin_add_reservation";
    }

    @PostMapping("/admin/reservations/store")
    public String addNewReservation(@ModelAttribute("newReservationRequest") NewReservationRequest newReservationRequest, RedirectAttributes redirectAttributes,HttpSession httpSession){

        if (!validationHelper.isValidNewReservationData(newReservationRequest)){
            redirectAttributes.addFlashAttribute("errorMessage", "Data is Invalid, enter valid data");
            return "redirect:/admin/reservations/add";
        }
        try {
            User user = userRepository.findById(Long.valueOf(newReservationRequest.getUserId())).orElse(null);
            Event event = eventRepository.findById(Long.valueOf(newReservationRequest.getEventId())).orElse(null);
            System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(user));
            System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(event));
            if (user==null || event==null){
                redirectAttributes.addFlashAttribute("errorMessage", "Data is Invalid, enter valid data");
                return "redirect:/admin/reservations/add";
            }
            Reservation reservation = new Reservation(
                    user,
                    event,
                    newReservationRequest.getNumberOfTickets(),
                    newReservationRequest.getReservationTime()
            );
            System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(reservation));
            String result = reservationService.addNewReservation(reservation);
            if (result.equalsIgnoreCase("success")) {
                redirectAttributes.addFlashAttribute("successMessage", "Reservation added successfully");
                User us = (User) httpSession.getAttribute("user");
                if (us.getRole().toString().equalsIgnoreCase("ADMIN")){
                    return "redirect:/admin/reservations";
                }else {
                    return "redirect:/user/reservations";
                }
            } else {
                redirectAttributes.addFlashAttribute("errorMessage", "Failed to create reservation.Please try again");
                return "redirect:/admin/reservations/add";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            redirectAttributes.addFlashAttribute("errorMessage", "Failed to create reservation.Please try again");
            return "redirect:/admin/reservations/add";
        }
    }



    @GetMapping("/user/reservations")
    public String user_reservations(Model model, HttpSession httpSession) {
        User user = (User)httpSession.getAttribute("user");
        model.addAttribute("userReservationsResponse",reservationService.getUserReservations(user.getId()));
        return "user_all_reservations";
    }

    @GetMapping("/admin/reservations")
    public String admin_reservations(Model model) {
        model.addAttribute("adminReservationResponse",reservationService.adminReservations());
        return "admin_all_reservations";
    }
}
