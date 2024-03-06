package com.rsp.controller;

import com.rsp.model.Passenger;
import com.rsp.model.Ticket;
import com.rsp.service.ITicketBookingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/passenger-api")
@Tag(name = "ticket booking api", description = "ticket booking controller")
public class TicketBookingController {



    @Autowired
    private ITicketBookingService service;

    private static final Logger logger = LoggerFactory.getLogger(TicketBookingController.class);

    @Operation(summary = "POST method", description = "creates a ticket for entered user, accepts passenger obj and returns ticket response")
    @PostMapping("/get-ticket")
    public ResponseEntity<Ticket> enrollPassenger(@RequestBody Passenger passenger){

        logger.debug("request reached api end point in controller");
        Passenger p = service.registerPassenger(passenger);
        Ticket t = service.createTicket(p);

        logger.info("Passenger obj saved");

        logger.warn("check db, if values are saved");

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
