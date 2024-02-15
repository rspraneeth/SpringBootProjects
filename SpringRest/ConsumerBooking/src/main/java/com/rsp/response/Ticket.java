package com.rsp.response;

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
    private String name;
    private String departure;
    private String arrival;
    private LocalDate dateOfJourney;

}