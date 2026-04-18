package com.chema.db.userapidb.service;

import org.springframework.stereotype.Service;
import com.chema.db.userapidb.repository.UserRepository;
import com.chema.db.userapidb.model.User;
import java.util.List;
import java.util.Optional;
import com.chema.db.userapidb.exception.UserNotFoundException;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User user) {
        User u = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        u.setName(user.getName());
        u.setAge(user.getAge());
        return userRepository.save(u);
    }

    public void deleteUser(Long id) {
        User u = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        userRepository.delete(u);
    }
}
