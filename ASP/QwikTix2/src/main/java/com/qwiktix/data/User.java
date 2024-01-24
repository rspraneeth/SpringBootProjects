package com.qwiktix.data;

import com.qwiktix.enums.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    @Column(unique = true)
    private String name;

    private String password;
    @Column(unique = true)
    private String email;
    private String dateOfBirth;
    @Enumerated(EnumType.STRING)
    private Role role;

    public User(String name, String email, String password, String dateOfBirth, Role role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.role = role;
    }
}
