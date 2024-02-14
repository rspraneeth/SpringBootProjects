package com.rsp.service;

import com.rsp.dao.ITicketRepo;
import com.rsp.model.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketBookingServiceImpl implements ITicketBookingService{

    @Autowired
    private ITicketRepo repo;
    @Override
    public Passenger registerPassenger(Passenger passenger) {
        return repo.save(passenger);
    }

    @Override
    public Passenger getPassengerInfo(Integer id) {
        return repo.findById(id).isPresent()?repo.findById(id).get():new Passenger();
    }
}
