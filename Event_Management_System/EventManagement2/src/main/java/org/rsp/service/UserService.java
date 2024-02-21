package org.rsp.service;

import org.rsp.dao.UserRepo;
import org.rsp.model.User;
import org.rsp.model.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    public void registerUser(User user) {
        userRepo.save(user);
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepo.findByEmail(email);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Service class, loadUserByUsernameMethod for "+username);
        Optional<User> optionalUser = userRepo.findByEmail(username);
        if(optionalUser.isEmpty()) {
            System.out.println("didnt find user, exception");
            throw new UsernameNotFoundException(username);
        }
        else{
            System.out.println(optionalUser.get());
            return new UserPrincipal(optionalUser.get());
        }

    }

    public User getUserById(Integer userId) {
        System.out.println("user id is "+userId);
        return userRepo.findById((long)userId).get();
    }
}
