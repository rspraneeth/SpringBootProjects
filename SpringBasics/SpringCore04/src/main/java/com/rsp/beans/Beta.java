package com.rsp.beans;

public class Beta {

    private Alpha alpha;

    public Beta(){
        System.out.println("Beta bean created.");
    }

    public void setAlpha(Alpha alpha) {
        this.alpha = alpha;
        System.out.println("setAlpha() method invoked and injecting Alpha into Beta object.");
    }

    public Beta(Alpha alpha){
        this.alpha = alpha;
    }
}
