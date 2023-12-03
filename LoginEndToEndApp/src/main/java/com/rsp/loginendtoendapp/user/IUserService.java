package com.rsp.loginendtoendapp.user;

import com.rsp.loginendtoendapp.registration.RegistrationRequest;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> getAllUsers();
    User registerUser(RegistrationRequest registrationRequest);
    User findByEmail(String email);
}
