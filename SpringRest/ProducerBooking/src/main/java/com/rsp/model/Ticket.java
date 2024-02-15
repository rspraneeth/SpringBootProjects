package com.rsp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class Ticket {
    @Id
    @SequenceGenerator(name = "ticket_next", initialValue = 97201)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket_next")
    private Integer ticketNumber;
    private String status;
    private Double cost;

    @ManyToOne
    private Passenger passenger;

}
