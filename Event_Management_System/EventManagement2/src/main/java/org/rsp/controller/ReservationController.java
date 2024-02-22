package org.rsp.controller;


import org.rsp.model.Reservation;
import org.rsp.model.ReservationReq;
import org.rsp.service.EventService;
import org.rsp.service.ReservationService;
import org.rsp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ReservationController {

    @Autowired
    private EventService eventService;

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private UserService userService;

    @GetMapping("/reservation/new/{eventId}")
    public String reservation(@PathVariable int eventId, Model model){
        model.addAttribute("event", eventService.findEventById(eventId));
        model.addAttribute("reservation", new ReservationReq());
        return "reservationform";
    }

    @PostMapping("/reservation/new")
    public String makeReservation(@ModelAttribute ReservationReq req){
        System.out.println(req);
        Reservation reservation = new Reservation(req.getTickets(), userService.getUserById(req.getUserId()), eventService.findEventById(req.getEventId()));
        reservationService.addReservation(reservation);
        return "all-reservations";
    }

    @GetMapping("/admin/reservation")
    public String newAdminReservation(Model model){

        model.addAttribute("events", eventService.getAllEvents());
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("resReq", new ReservationReq());
        return "admin-add-reservation";
    }

    @PostMapping("/admin/reservation/add")
    public String makeAdminReservation(@ModelAttribute ReservationReq resReq, Model model){
        Reservation reservation = new Reservation(resReq.getTickets(), userService.getUserById(resReq.getUserId()), eventService.findEventById(resReq.getEventId()));
        System.out.println(reservation);
        reservationService.addReservation(reservation);
        model.addAttribute("reservations", reservationService.getAll());
        return "all-reservations";
    }

    @GetMapping("/admin/all-reservations")
    public String allReservationsAdmin(Model model){
        model.addAttribute("reservations", reservationService.getAll());
        return "all-reservations";
    }
}
