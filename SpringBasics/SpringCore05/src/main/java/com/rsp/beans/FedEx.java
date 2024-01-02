package com.rsp.beans;

public class FedEx implements CourierService{

    static {
        System.out.println("FedEx class is loaded");
    }

    public FedEx(){
        System.out.println("FedEx class is instantiated.");
    }
    @Override
    public boolean courierService(double amount) {
        System.out.println("Courier delivered through FedEx and amount paid is "+amount);
        return true;
    }
}
