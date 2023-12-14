package org.rsp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String category;
    private LocalDateTime dateTime;
    private String venue;
    private int availableTickets;
    private double ticketPrice;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] image;
}
