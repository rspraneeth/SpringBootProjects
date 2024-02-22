package com.rsp.pojo;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@XmlRootElement
public class Course {
    private Integer id;
    private String name;
    private Double price;
}
