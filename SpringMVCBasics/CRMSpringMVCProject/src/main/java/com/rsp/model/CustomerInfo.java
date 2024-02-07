package com.rsp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Setter@Getter
public class CustomerInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String city;
    private Double salary;

    public CustomerInfo() {
        System.out.println("Customer bean is created, in zero param constructor...");
    }
}
