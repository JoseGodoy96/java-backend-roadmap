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

    // DELETE /users/name
    @DeleteMapping("/{name}")
    public String deleteUser(@PathVariable String name) {

        int i = 0;
        while (i < users.size()) {
            if (users.get(i).name.equalsIgnoreCase(name)) {
                users.remove(i);
                return "User deleted";
            }
            i++;
        }

        return "User not found";
    }

    // PUT /users/name
    @PutMapping("/{name}")
    public String updateUser(@PathVariable String name, @RequestBody User updatedUser) {

        for (User user : users) {
            if (user.name.equalsIgnoreCase(name)) {
                user.age = updatedUser.age;
                return "User updated";
            }
        }

        return "User not found";
    }
}
