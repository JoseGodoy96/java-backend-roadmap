package com.chema.db.userapidb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.chema.db.userapidb.model.User;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByNameContainingIgnoreCase(String name);
}
