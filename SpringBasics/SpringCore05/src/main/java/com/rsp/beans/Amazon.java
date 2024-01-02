package com.rsp.beans;

public class Amazon {
    private CourierService service;
    private Trial trial;

    public void setTrial(Trial trial) {
        this.trial = trial;
    }

    static {
        System.out.println("Amazon class is loaded.");
    }

    public Amazon(){
        System.out.println("Amazon class instantiated");
    }

//    public Amazon(CourierService service) {
//        this.service = service;
//    }

    public void setService(CourierService service) {
        this.service = service;
        System.out.println("Setter is invoked to perform injection.");
    }

    public boolean initiateDelivery(double amount){
        return service.courierService(amount);
    }
}
