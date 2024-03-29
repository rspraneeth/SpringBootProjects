package com.rsp.service;

import com.rsp.dao.IPassengerRepo;
import com.rsp.dao.ITicketRepo;
import com.rsp.model.Passenger;
import com.rsp.model.Ticket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class TicketBookingServiceImpl implements ITicketBookingService{

    private static final Logger logger = LoggerFactory.getLogger(TicketBookingServiceImpl.class);

    @Autowired
    private IPassengerRepo repo;

    @Autowired
    private ITicketRepo ticketRepo;
    @Override
    public Passenger registerPassenger(Passenger passenger) {
        logger.error("just checking error console");
        return repo.save(passenger);
    }

    @Override
    public Passenger getPassengerInfo(Integer id) {
        return repo.findById(id).isPresent()?repo.findById(id).get():new Passenger();
    }

    @Override
    public Ticket  getTicketInfo(Integer tktNum) {
        logger.trace("checking trace");
       return ticketRepo.findById(tktNum).orElseThrow();
    }

    @Override
    public Ticket createTicket(Passenger p) {
        Ticket ticket = new Ticket();
        ticket.setPassenger(p);
        ticket.setCost(new Random().nextDouble(111.01, 399.99));
        ticket.setStatus("Confirmed");
        return ticketRepo.save(ticket);
    }
}
