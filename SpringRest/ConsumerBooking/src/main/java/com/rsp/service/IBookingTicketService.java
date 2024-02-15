package com.rsp.service;

import com.rsp.request.Passenger;
import com.rsp.response.Ticket;

public interface IBookingTicketService {
    public Ticket bookTicket(Passenger passenger);
    public Ticket fetchTicketInfo(Integer tktNumber);
}
