package com.rsp.controller;

import com.rsp.model.Passenger;
import com.rsp.model.Ticket;
import com.rsp.service.ITicketBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/passengers")
public class TicketBookingController {

    @Autowired
    private ITicketBookingService service;

    @PostMapping("/getTicketNumber")
    public ResponseEntity<Ticket> enrollPassenger(@RequestBody Passenger passenger){

        Passenger p = service.registerPassenger(passenger);
        Ticket t = new Ticket();
        t.setTicketNumber(p.getId());
        t.setName(p.getName());
        t.setArrival(p.getArrival());
        t.setDeparture(p.getDeparture());
        t.setStatus("Confirmed");
        t.setDateOfJourney(p.getDateOfJourney());
        t.setCost(678.98);

        return new ResponseEntity<>(t, HttpStatus.OK);
    }
}
