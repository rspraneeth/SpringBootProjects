package com.rsp.controller;

import com.rsp.request.Passenger;
import com.rsp.response.Ticket;
import com.rsp.service.IBookingTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/booking-api")
public class BookingController {

    @Autowired
    private IBookingTicketService service;

    @GetMapping("/book")
    public String bookTicketForm(Model model){
        model.addAttribute("passanger", new Passenger());
        return "index";
    }

    @PostMapping("/book")
    public String bookTicket(@ModelAttribute Passenger passenger, Model model){
        System.out.println("Passenger from from in controller"+passenger);
        Ticket tkt = service.bookTicket(passenger);
        model.addAttribute("ticketNumber", tkt);

        return "ticket-details";
    }


    @GetMapping("/get-ticket")
    public String getTicketDetails(@RequestParam Integer conf, Model model){

        Ticket tkt = service.fetchTicketInfo(conf);
        model.addAttribute("ticketNumber", tkt);

        return "ticket-details";
    }
}
