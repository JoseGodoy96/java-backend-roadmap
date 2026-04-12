package com.chema.db.userapidb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import com.chema.db.userapidb.repository.UserRepository;
import com.chema.db.userapidb.model.User;

@SpringBootApplication
public class UserApiDbApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApiDbApplication.class, args);
    }

    @Bean
    CommandLineRunner run(UserRepository userRepository) {
        return args -> {
            User user = new User();
            user.setName("Jose");
            user.setAge(30);

            userRepository.save(user);

            userRepository.findAll().forEach(u -> {
                System.out.println(u.getName());
            });
        };
    }
}
