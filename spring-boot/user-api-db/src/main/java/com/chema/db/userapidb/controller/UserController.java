package com.chema.db.userapidb.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.chema.db.userapidb.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import com.chema.db.userapidb.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;
import com.chema.db.userapidb.dto.UserDto;
import com.chema.db.userapidb.dto.UserResponseDto;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public List<UserResponseDto> getAllUsers() {
        return userService.getAllUsers()
                .stream()
                .map(user -> {
                    UserResponseDto dto = new UserResponseDto();
                    dto.setId(user.getId());
                    dto.setName(user.getName());
                    dto.setAge(user.getAge());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @PostMapping
    public User createUser(@Valid @RequestBody UserDto userDto) {
        User user = new User();
        user.setName((userDto.getName()));
        user.setAge(userDto.getAge());

        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> updateUser (@PathVariable Long id, @Valid @RequestBody UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setAge(userDto.getAge());

        User updatedUser = userService.updateUser(id, user);

        UserResponseDto response = new UserResponseDto();
        response.setId(updatedUser.getId());
        response.setName(updatedUser.getName());
        response.setAge(updatedUser.getAge());

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
