package com.rsp;

import org.springframework.stereotype.Component;

@Component
public class FirstFlight implements CourierService{

    static {
        System.out.println("First Flight class loaded");
    }

    public FirstFlight(){
        System.out.println("FirstFlight class instantiated.");
    }

    @Override
    public void courierService(double amount) {
        System.out.println("Courier delivered through first flight and amount paid is "+amount);
    }
}
