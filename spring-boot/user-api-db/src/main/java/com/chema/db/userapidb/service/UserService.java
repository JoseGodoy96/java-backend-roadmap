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

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public Optional<User> getUserById(Long id) { return userRepository.findById(id); }
}
