package com.rsp.pojo;

import lombok.AllArgsConstructor;
import lombok.ToString;
import org.springframework.hateoas.RepresentationModel;

@AllArgsConstructor @ToString
public class Course extends RepresentationModel {

    private Integer id;
    private String name;
    private Double price;
}
