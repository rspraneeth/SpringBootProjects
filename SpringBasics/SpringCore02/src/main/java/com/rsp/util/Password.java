package com.rsp.util;


public class Password {
    public Password(String algo){
        System.out.println("Algo used is "+algo);
    }

    public void disp(){
        System.out.println("Password obj created by dev, but still its a bean, " +
                "managed by spring container.");
    }
}
