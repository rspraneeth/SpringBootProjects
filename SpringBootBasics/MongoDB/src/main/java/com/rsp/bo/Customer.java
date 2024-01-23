package com.rsp.bo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document

public class Customer {

    @Id
    private String id;

    private Integer cusNo;
    private String name;
    private String city;

    public Customer(String id, Integer cusNo, String name, String city) {
        this.id = id;
        this.cusNo = cusNo;
        this.name = name;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", cusNo=" + cusNo +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public Customer() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getCusNo() {
        return cusNo;
    }

    public void setCusNo(Integer cusNo) {
        this.cusNo = cusNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
