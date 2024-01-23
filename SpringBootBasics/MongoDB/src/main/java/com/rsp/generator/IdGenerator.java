package com.rsp.generator;

import java.util.UUID;

public class IdGenerator {
    public static String generateId(){
        System.out.println("Custom id generator is called");
        return UUID.randomUUID().toString();
    }
}
