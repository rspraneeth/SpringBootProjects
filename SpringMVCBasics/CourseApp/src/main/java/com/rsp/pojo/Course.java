package com.rsp.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString@AllArgsConstructor
public class Course {
    private Integer cid;
    private String cname;
    private Double price;
    private String courseDuration;


}
