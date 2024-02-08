package com.rsp.pojo;

public class Details {
    private String name;
    private String mail;
    private Double salary;

    @Override
    public String toString() {
        return "Details{" +
                "name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                ", salary=" + salary +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
