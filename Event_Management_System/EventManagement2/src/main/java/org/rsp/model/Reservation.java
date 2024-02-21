package org.rsp.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer tickets;

    @ManyToOne
    private User user;

    @ManyToOne
    private Event event;

    public Reservation(Integer tickets, User user, Event event) {
        this.tickets = tickets;
        this.user = user;
        this.event = event;
    }
}
