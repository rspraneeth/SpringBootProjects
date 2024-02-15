package com.rsp.controller;

import com.rsp.model.Passenger;
import com.rsp.model.Ticket;
import com.rsp.service.ITicketBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/passenger-api")
public class TicketBookingController {

    @Autowired
    private ITicketBookingService service;

    @PostMapping("/get-ticket")
    public ResponseEntity<Ticket> enrollPassenger(@RequestBody Passenger passenger){

        Passenger p = service.registerPassenger(passenger);
        Ticket t = service.createTicket(p);

        return new ResponseEntity<>(t, HttpStatus.OK);
    }

    @GetMapping("/get-ticket/{tktNum}")
    public ResponseEntity<Ticket> getTicketDetails(@PathVariable Integer tktNum){

        Ticket ticket = service.getTicketInfo(tktNum);
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }

    @GetMapping("/get-passenger/{id}")
    public ResponseEntity<Passenger> getPassengerDetails(@PathVariable Integer id){
        Passenger pas = service.getPassengerInfo(id);
        return new ResponseEntity<>(pas, HttpStatus.OK);
    }
}
