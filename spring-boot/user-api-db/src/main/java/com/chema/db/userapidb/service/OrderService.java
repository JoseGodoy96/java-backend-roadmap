package com.chema.db.userapidb.service;

import org.springframework.stereotype.Service;
import com.chema.db.userapidb.repository.OrderRepository;
import com.chema.db.userapidb.repository.UserRepository;
import com.chema.db.userapidb.model.Order;
import com.chema.db.userapidb.model.User;
import com.chema.db.userapidb.exception.UserNotFoundException;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public OrderService(OrderRepository orderRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    public Order createOrderForUser(Long userId, Order order) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));

        order.setUser(user);
        return orderRepository.save(order);
    }

    public List <Order> getOrdersByUserId(Long userId) {
        userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));

        return orderRepository.findByUserId(userId);
    }
}
