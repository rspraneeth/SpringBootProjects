package com.rsp.beans;

public class Bluedart implements CourierService {

    static {
        System.out.println("BlueDart class is loaded");
    }

    public Bluedart(){
        System.out.println("BlueDart class instantiated.");
    }

    @Override
    public boolean courierService(double amount) {
        System.out.println("Courier delivered through bluedart and amount paid is "+amount);
        return true;
    }
}
