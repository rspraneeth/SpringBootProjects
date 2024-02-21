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
}
