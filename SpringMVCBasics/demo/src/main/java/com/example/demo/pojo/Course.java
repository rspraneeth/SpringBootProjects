package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.hateoas.RepresentationModel;

@AllArgsConstructor
@ToString
@Getter@Setter
public class Course extends RepresentationModel {

    private Integer id;
    private String name;
    private Double price;
}