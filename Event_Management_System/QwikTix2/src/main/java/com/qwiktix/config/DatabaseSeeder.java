package com.qwiktix.config;

import com.qwiktix.data.User;
import com.qwiktix.enums.Role;
import com.qwiktix.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DatabaseSeeder {

    @Autowired
    private UserRepository userRepository;

    @Bean
    public CommandLineRunner seedDatabase(){
        return args -> {
            User user1 = new User("admin","admin@gmail.com","123456","12/12/1999", Role.ADMIN);
            User user2 = new User("user","user@gmail.com","123456","12/10/1999", Role.USER);
            if(userRepository.count()==0) {
                userRepository.saveAll(List.of(user1, user2));
            }
        };
    }
}
