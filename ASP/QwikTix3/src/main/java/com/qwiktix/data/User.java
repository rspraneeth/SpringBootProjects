package com.qwiktix.data;

import com.qwiktix.enums.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank(message = "Name is required")
    @Column(unique = true)
    private String name;
    @NotBlank(message = "Name is required")
    @Column(unique = true)
    private String username;
    @NotBlank(message = "Name is required")
    private String password;
    @Column(unique = true)
    private String email;
    private String dateOfBirth;
    @Enumerated(EnumType.STRING)
    private Role role;

    public User(String name,String username, String email, String password, String dateOfBirth, Role role) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.role = role;
    }
}
