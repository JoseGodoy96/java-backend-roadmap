package com.chema.userapi;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private List<User> users = new ArrayList<>();

    // GET /users
    @GetMapping
    public List<User> getUsers() {
        return users;
    }

    // POST /users
    @PostMapping
    public String addUser(@RequestBody User user) {
        users.add(user);
        return "User added";
    }
}
