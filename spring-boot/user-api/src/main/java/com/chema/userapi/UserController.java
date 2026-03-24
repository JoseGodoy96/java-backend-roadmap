package com.chema.userapi;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

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

    // GET /{id}
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) {

        for (User user : users) {
            if (user.id == id) {
                return ResponseEntity.ok(user);
            }
        }

        return ResponseEntity.status(404).body("User not found");
    }

    // POST /users
    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody User user) {

        if (user.name == null || user.name.isEmpty()) {
            return ResponseEntity.badRequest().body("Name is required");
        }

        if (user.age == null) {
            return ResponseEntity.badRequest().body("Age is required");
        }

        user.id = nextId++;
        users.add(user);

        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) {

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).id == id) {
                users.remove(i);
                return ResponseEntity.ok("User deleted");
            }
        }

        return ResponseEntity.status(404).body("User not found");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable int id, @RequestBody User updatedUser) {

        for (User user : users) {
            if (user.id == id) {

                if (updatedUser.name != null) {
                    user.name = updatedUser.name;
                }

                if (updatedUser.age != null) {
                    user.age = updatedUser.age;
                }

                return ResponseEntity.ok(user);
            }
        }

        return ResponseEntity.status(404).body("User not found");
    }
}
