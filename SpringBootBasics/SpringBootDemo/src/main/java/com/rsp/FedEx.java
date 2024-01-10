package com.rsp;

import org.springframework.stereotype.Component;

@Component
public class FedEx implements CourierService{

    static {
        System.out.println("FedEx class is loaded");
    }

    public FedEx(){
        System.out.println("FedEx class is instantiated.");
    }
    @Override
    public void courierService(double amount) {
        System.out.println("Courier delivered through FedEx and amount paid is "+amount);
    }
}
