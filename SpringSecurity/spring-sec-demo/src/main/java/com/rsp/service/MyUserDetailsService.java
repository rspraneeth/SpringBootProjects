package com.rsp.service;

import com.rsp.dao.UserDao;
import com.rsp.model.User;
import com.rsp.model.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDao userDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);
        if (user==null) throw new UsernameNotFoundException("User not found");
        return new UserPrincipal(user);
    }

    public User registerUser(User user) {
        return userDao.save(user);
    }
}
