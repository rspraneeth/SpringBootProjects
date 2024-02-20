package org.rsp.config;

import org.rsp.dao.UserRepo;
import org.rsp.enums.Role;
import org.rsp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
public class DatabaseSeeder {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public CommandLineRunner seedDatabase(){

        return args -> {
            User user1 = new User("rsp", "rsp@gmail.com", passwordEncoder.encode("123456"), Role.USER);
            User user2 = new User("admin", "admin@gmail.com", passwordEncoder.encode("123456"), Role.ADMIN);
            if (userRepo.count()==0){
                userRepo.saveAll(List.of(user1, user2));
            }
        };
    }
}
