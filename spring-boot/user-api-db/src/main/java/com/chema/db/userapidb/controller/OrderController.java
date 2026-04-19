package com.chema.db.userapidb.controller;

import com.chema.db.userapidb.dto.OrderResponseDto;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.chema.db.userapidb.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.chema.db.userapidb.dto.OrderDto;
import com.chema.db.userapidb.model.Order;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@RestController
@RequestMapping("/users")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{userId}/orders")
    public List<OrderResponseDto> getOrdersByUser(@PathVariable Long userId) {
        return orderService.getOrdersByUserId(userId)
                .stream()
                .map(order -> {
                    OrderResponseDto dto = new OrderResponseDto();
                    dto.setId(order.getId());
                    dto.setDescription(order.getDescription());
                    return dto;
                })
                .toList();
    }

    @PostMapping("/{userId}/orders")
    public Order createOrder(@PathVariable Long userId, @RequestBody OrderDto orderDto) {

        Order order = new Order();
        order.setDescription(orderDto.getDescription());

        return orderService.createOrderForUser(userId, order);
    }
}
