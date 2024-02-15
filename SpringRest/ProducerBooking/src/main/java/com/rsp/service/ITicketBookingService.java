package com.rsp.service;

import com.rsp.model.Passenger;
import com.rsp.model.Ticket;

import java.util.Optional;

public interface ITicketBookingService {
    Passenger registerPassenger(Passenger passenger);
    Passenger getPassengerInfo(Integer id);

    Ticket getTicketInfo(Integer tktNum);

    Ticket createTicket(Passenger p);
}
