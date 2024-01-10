package com.rsp;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class BlueDart implements CourierService {

    static {
        System.out.println("BlueDart class is loaded");
    }

    public BlueDart(){
        System.out.println("BlueDart class instantiated.");
    }

    @Override
    public void courierService(double amount) {
        System.out.println("Courier delivered through bluedart and amount paid is "+amount);
    }
}
