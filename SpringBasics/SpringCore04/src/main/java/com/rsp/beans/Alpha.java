package com.rsp.beans;

public class Alpha {

    private Beta beta;
    public Alpha(){
        System.out.println("Alpha bean created");
    }

    public void setBeta(Beta beta) {
        this.beta = beta;
        System.out.println("setBeta() invoked and injecting Beta into Alpha object.");
    }

    public Alpha(Beta beta){
        this.beta = beta;
    }


}
