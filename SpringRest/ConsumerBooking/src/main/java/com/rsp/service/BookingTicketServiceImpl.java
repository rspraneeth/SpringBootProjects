package com.rsp.service;

import com.rsp.request.Passenger;
import com.rsp.response.Ticket;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class BookingTicketServiceImpl implements IBookingTicketService{

    private static final String reg_url="http://localhost:8080/passenger-api/get-ticket";
    private static final String get_url="http://localhost:8080/passenger-api/get-ticket/{tktNumber}";

    @Override
    public Ticket bookTicket(Passenger passenger) {
        System.out.println("Passenger in integration logic method: "+passenger);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Ticket> response = restTemplate.postForEntity(reg_url, passenger, Ticket.class);
        return response.getBody();
    }

    @Override
    public Ticket fetchTicketInfo(Integer tktNumber) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Ticket> res = restTemplate.getForEntity(get_url, Ticket.class, tktNumber);
        return res.getBody();
    }
}
