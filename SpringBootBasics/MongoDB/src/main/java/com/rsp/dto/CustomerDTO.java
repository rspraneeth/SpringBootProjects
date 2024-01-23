package com.rsp.dto;

public class CustomerDTO {
    private String id;
    private Integer cusNo;
    private String name;
    private String city;

    public CustomerDTO(Integer cusNo, String name, String city) {
        this.cusNo = cusNo;
        this.name = name;
        this.city = city;
    }

    public String getId() {
        return id;
    }

    public CustomerDTO(String id, Integer cusNo, String name, String city) {
        this.id = id;
        this.cusNo = cusNo;
        this.name = name;
        this.city = city;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "id='" + id + '\'' +
                ", cusNo=" + cusNo +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public CustomerDTO() {
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
