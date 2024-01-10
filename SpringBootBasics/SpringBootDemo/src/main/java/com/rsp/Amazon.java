package com.rsp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Amazon {


    private CourierService service;

    static {
        System.out.println("Amazon class is loaded.");
    }

    public Amazon(){
        System.out.println("Amazon class instantiated");
    }

    @Autowired
    public Amazon(@Qualifier("blueDart") CourierService service) {
        this.service = service;
    }

    
    //can use annotation on field level, setter, constructor

//    public void setService(CourierService service) {
//        this.service = service;
//        System.out.println("Setter is invoked to perform injection.");
//    }

    public void initiateDelivery(double amount){
        service.courierService(amount);
    }
}
