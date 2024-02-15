package com.rsp.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Passenger {
    private Integer id;
    private String name;
    private String departure;
    private String arrival;
    private LocalDate dateOfJourney;
}
