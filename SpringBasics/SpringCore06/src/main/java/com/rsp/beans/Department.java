package com.rsp.beans;

public class Department {
    private Integer depNO;
    private String depName;

    @Override
    public String toString() {
        return "Department{" +
                "depNO=" + depNO +
                ", depName='" + depName + '\'' +
                '}';
    }

    public Department(Integer depNO, String depName) {
        this.depNO = depNO;
        this.depName = depName;
        System.out.println("Department bean is created.");
    }

    public Department() {
    }
}
