package com.rsp.loginendtoendapp.registration.token;

import com.rsp.loginendtoendapp.user.User;

import java.util.Optional;

public interface IVerificationTokenService {
    String validateToken(String token);
    void saveVerificationTokenForUser(User user, String token);
    Optional<VerificationToken> findByToken(String token);
}
