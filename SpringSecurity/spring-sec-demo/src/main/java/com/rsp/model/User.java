package com.rsp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "users")
@Data
public class User {

    @Id
    private int id;
    private String username;
    private String password;
}
