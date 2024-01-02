package com.rsp.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Amazon {
    @Autowired
    @Qualifier("fe")
    private CourierService service;

    static {
        System.out.println("Amazon class is loaded.");
    }

    public Amazon(){
        System.out.println("Amazon class instantiated");
    }

//    public Amazon(CourierService service) {
//        this.service = service;
//    }

    @Autowired
    @Qualifier("ff")
    public void setService(CourierService service) {
        this.service = service;
        System.out.println("Setter is invoked to perform injection.");
    }

    public void initiateDelivery(double amount){
        service.courierService(amount);
    }
}
