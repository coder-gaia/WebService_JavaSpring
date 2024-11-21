package com.alexandre.webService.config;

import com.alexandre.webService.entities.User;
import com.alexandre.webService.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {
        User u = new User(null, "James", "james@gmail.com", "jamie123", "42668964925");
        User u_2 = new User(null, "Cersei", "bitch@gmail.com", "bitch123", "42218961963");

        userRepository.saveAll(Arrays.asList(u, u_2));
    }
}
