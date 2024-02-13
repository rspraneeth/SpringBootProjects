package com.rsp.exception;

public class TouristNotFoundException extends RuntimeException{
    public TouristNotFoundException(String msg){
        super(msg);
    }
}
