package com.rsp.dao;


import org.springframework.stereotype.Repository;

@Repository(value = "repo")
public class Dao {
    public Dao(){
        System.out.println("dao  object is created.");
    }
}
