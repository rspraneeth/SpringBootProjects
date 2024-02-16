package com.rsp.service;

import com.rsp.request.Passenger;
import com.rsp.response.Ticket;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.URI;

@Service
public class BookingTicketServiceImpl implements IBookingTicketService{

    private static final String reg_url="http://localhost:8080/passenger-api/get-ticket";
    private static final String get_url="http://localhost:8080/passenger-api/get-ticket/{tktNumber}";

    @Override
    public Ticket bookTicket(Passenger passenger) {
        System.out.println("Passenger in integration logic method: "+passenger);
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<Ticket> response = restTemplate.postForEntity(reg_url, passenger, Ticket.class);
//        return response.getBody();

        //get webclient object, then send the request and process data
        WebClient webClient = WebClient.create();
        Ticket ticket = webClient.post() // post mapping
                            .uri(reg_url) // to the url
                            .bodyValue(passenger) // passing/binding a body(RequestBody)
                            .retrieve() // and then the method returns
                            .bodyToMono(Ticket.class) //a response mapped with a ticket type object
                            .block(); // as this is synchronous.
/* This code snippet utilizes Spring WebFlux WebClient to perform a POST request to a specified URL,
passing a passenger object in the request body, and then retrieving the response body and mapping
it to a Ticket object. Finally, it blocks the execution until the response is received synchronously.

Perform a POST request using WebClient
Mono<Ticket> ticketMono = webClient.post() // Specify the HTTP method as POST
                            .uri(reg_url) // Set the URI to send the request
                            .bodyValue(passenger) // Set the request body with the passenger object
                            .retrieve() // Retrieve the response
                            .bodyToMono(Ticket.class); // Map the response body to a Ticket object

// Block and wait for the response synchronously, returning a Ticket object
Ticket ticket = ticketMono.block(); */

        System.out.println(ticket);

        return ticket;
    }

    @Override
    public Ticket fetchTicketInfo(Integer tktNumber) {
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<Ticket> res = restTemplate.getForEntity(get_url, Ticket.class, tktNumber);
//        return res.getBody();

        WebClient webClient = WebClient.create();
        Ticket ticket = webClient.get()
                .uri(get_url, tktNumber)
                .retrieve()
                .bodyToMono(Ticket.class)
                .block(); //if asynchronous use subscribe

        System.out.println(ticket);

        return ticket;
    }
}
