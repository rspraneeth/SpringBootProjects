package com.rsp.service;

import com.rsp.model.Passenger;

public interface ITicketBookingService {
    public Passenger registerPassenger(Passenger passenger);
    public Passenger getPassengerInfo(Integer id);
}
