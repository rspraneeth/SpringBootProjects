package com.rsp.bo;

import jakarta.persistence.*;

@Entity
@Table(name = "VaccineInfo")
public class VaccineDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String company;
    private Integer price;

    public VaccineDetails() {
        System.out.println("Zero param constructor for VaccineDetails Obj");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }


    public VaccineDetails(String name, String company, Integer price) {
        this.name = name;
        this.company = company;
        this.price = price;
    }

    @Override
    public String toString() {
        return "VaccineDetails{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", price=" + price +
                '}';
    }

    public Long getId() {
        return id;
    }
}
