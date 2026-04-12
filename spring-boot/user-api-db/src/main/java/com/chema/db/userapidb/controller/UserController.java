package com.chema.db.userapidb.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.chema.db.userapidb.repository.UserRepository;

public class UserController {

    @RestController
    @RequestMapping("/users")
    public class UserController {

        private final UserRepository userRepository;

        public UserController(UserRepository userRepository) {
            this.userRepository = userRepository;
        }

    }
}
