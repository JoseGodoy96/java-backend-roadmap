package com.chema.userapi;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private List<User> users = new ArrayList<>();
    private int nextId = 1;

    // GET /users
    @GetMapping
    public List<User> getUsers() {
        return users;
    }

    // POST /users
    @PostMapping
    public String addUser(@RequestBody User user) {
        user.id = nextId++;
        users.add(user);
        return "User added";
    }

    // DELETE /users/{id}
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {

        int i = 0;
        while (i < users.size()) {
            if (users.get(i).id == id) {
                users.remove(i);
                return "User deleted";
            }
            i++;
        }

        return "User not found";
    }

    // PUT /users/{id}
    @PutMapping("/{id}")
    public String updateUser(@PathVariable int id, @RequestBody User updatedUser) {

        for (User user : users) {
            if (user.id == id) {
                user.name = updatedUser.name;
                user.age = updatedUser.age;
                return "User updated";
            }
        }

        return "User not found";
    }
}
