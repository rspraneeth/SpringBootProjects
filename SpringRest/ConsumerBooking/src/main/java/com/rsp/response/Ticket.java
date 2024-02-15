package com.rsp.response;

import com.rsp.request.Passenger;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Ticket {
    private Integer ticketNumber;
    private String status;
    private Double cost;
    private Passenger passenger;

}