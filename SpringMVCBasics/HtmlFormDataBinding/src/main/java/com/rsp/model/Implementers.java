package com.rsp.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString
public class Implementers {
    private Integer id;
    private String name;
    private String city;
    private Double salary;

    public Implementers() {
        System.out.println("Zero param constructor of Implementers obj");
    }
}
