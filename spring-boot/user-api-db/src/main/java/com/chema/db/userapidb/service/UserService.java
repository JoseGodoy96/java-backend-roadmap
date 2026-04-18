package com.chema.db.userapidb.service;

import org.springframework.stereotype.Service;
import com.chema.db.userapidb.repository.UserRepository;
import com.chema.db.userapidb.model.User;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User user) {
        Optional<User> existingUser = userRepository.findById(id);

        if (existingUser.isPresent()) {
            User u = existingUser.get();
            u.setName(user.getName());
            u.setAge(user.getAge());
            return userRepository.save(u);
        } else {
            throw new RuntimeException("User not found");
        }
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public Optional<User> getUserById(Long id) { return userRepository.findById(id); }
}
